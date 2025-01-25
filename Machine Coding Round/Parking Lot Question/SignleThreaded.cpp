#include <bits/stdc++.h>
using namespace std;

class SearchManager {
public:
    unordered_map<string, string> cache;

    void index(const string &spotId, const string &vehicleNumber, const string &ticketId) {
        cache[vehicleNumber] = spotId;
        cache[ticketId] = spotId;
    }

    string findSpot(const string &query) {
        if (cache.find(query) != cache.end()) {
            return cache[query];
        } else {
            return "Not parked here";
        }
    }
};

class ParkingFloor {
private:
    int floor;
    vector<vector<int>> parking;
    vector<vector<bool>> reserved;
    unordered_map<int, atomic<int>> freeSpotsCount;
    SearchManager &searchmanager;

public:
    ParkingFloor(int floor, vector<vector<int>> &parking, vector<int> vehicleTypes, SearchManager &searchmanager)
        : floor(floor), parking(parking), searchmanager(searchmanager) {
            
        
        int row = parking.size();
        int col = parking[0].size();
        reserved = vector<vector<bool>>(row, vector<bool>(col, false));

        for (int type : vehicleTypes) {
            freeSpotsCount[type] = 0;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int parkingSpot = parking[i][j];
                if (parkingSpot != 0) {
                    freeSpotsCount[parkingSpot]++;
                }
            }
        }
    }

    // Function to park a vehicle
    string Park(int vehicleType, const string &vehicleNumber) {
        int row = parking.size();
        int col = parking[0].size();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (parking[i][j] == vehicleType && !reserved[i][j]) {
                    reserved[i][j] = true;
                    freeSpotsCount[vehicleType]--;
                    string spotId = to_string(floor) + "-" + to_string(i) + "-" + to_string(j);
                    string ticketId = vehicleNumber + "-" + spotId;
                    searchmanager.index(spotId, vehicleNumber, ticketId);
                    return spotId;
                }
            }
        }
        return "";  // No spot available
    }

    // Function to unpark a vehicle
    bool unPark(int row, int col) {
        int parkingType = parking[row][col];
        if (!reserved[row][col] || parkingType == 0) {
            return false;  // Spot not reserved or invalid parking type
        }
        reserved[row][col] = false;
        
        freeSpotsCount[parkingType]++;
        return true;
    }

    // Function to get the count of free spots for a specific vehicle type
    int freeSpotCount(int vehicleType) {
        return freeSpotsCount[vehicleType];
    }
};

class ParkManager {
public:
    // Function to park a vehicle based on the selected method
    string park(vector<ParkingFloor> &floors, int parkingMethod, int vehicleType, const string &vehicleNumber) {
        if (parkingMethod == 0) {
            return parkNearest(floors, vehicleType, vehicleNumber);
        } else if (parkingMethod == 1) {
            return parkMostFreeSpots(floors, vehicleType, vehicleNumber);
        }
        return "";  // Invalid parking method
    }

private:
    // Function to park at the nearest available spot
    string parkNearest(vector<ParkingFloor> &floors, int vehicleType, const string &vehicleNumber) {
        for (int i = 0; i < floors.size(); i++) {
            string spotId = floors[i].Park(vehicleType, vehicleNumber);
            if (spotId != "") {
                return spotId;
            }
        }
        return "No spot available"; // Return message if no spot is available
    }

    // Function to park in the floor with most free spots
    string parkMostFreeSpots(vector<ParkingFloor> &floors, int vehicleType, const string &vehicleNumber) {
        int floorIndex = -1;
        int maxFreeSpot = -1;

        for (int i = 0; i < floors.size(); i++) {
            int count = floors[i].freeSpotCount(vehicleType);
            if (count > maxFreeSpot) {
                maxFreeSpot = count;
                floorIndex = i;
            }
        }

        if (floorIndex >= 0) {
            string spotId = floors[floorIndex].Park(vehicleType, vehicleNumber);
            if (!spotId.empty()) {
                return spotId;
            }
        }
        return "No spot available"; // Return message if no spot is available
    }
};

int main() {
    // Vehicle types: 2 for bike, 4 for car
    vector<int> vehicleTypes = {2, 4};
    
    // Parking layout for each floor
    vector<vector<vector<int>>> parking = {
        {{2, 4, 0}, {4, 0, 2}, {0, 2, 4}},
        {{4, 2, 0}, {0, 2, 4}, {4, 2, 0}}
    };

    // Create a vector to store parking floors
    vector<ParkingFloor> lot;
    SearchManager searchManager;
    for (int i = 0; i < parking.size(); i++) {
        lot.push_back(ParkingFloor(i, parking[i], vehicleTypes, searchManager));
    }

    // Create ParkManager instance
    ParkManager parkManager;

    // Try parking a car (vehicle type 4) using nearest method
    cout << "Parking spot for vehicle type 4: " << parkManager.park(lot, 0, 4, "ABC123") << endl;
    
    // Try parking a bike (vehicle type 2) using the method of most free spots
    cout << "Parking spot for vehicle type 2: " << parkManager.park(lot, 1, 2, "XYZ456") << endl;

    // Print available spots for cars on floor 0
    cout << "Available spots for vehicle type 4 on floor 0: " << lot[0].freeSpotCount(4) << endl;



    return 0;
}
