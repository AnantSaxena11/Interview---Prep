#include <iostream>
#include <vector>
#include <unordered_map>
#include <atomic>
#include <string>

using namespace std;

class ParkingFloor
{
public:
    int floor;
    vector<vector<int>> parking;
    vector<vector<bool>> reserved;
    unordered_map<int, atomic<int>> freeSpotsCount;

    ParkingFloor(int floor, vector<vector<int>> &parking, vector<int> &vehicleTypes)
    {
        // Initialize the floor number and parking layout
        this->floor = floor;
        this->parking = parking;

        // Get the number of rows and columns in the parking layout
        int row = parking.size();
        int col = parking[0].size();

        // Create a reserved matrix of the same size as parking
        reserved = vector<vector<bool>>(row, vector<bool>(col, false));

        // Set freeSpotsCount for each vehicle type to 0
        for (int i = 0; i < vehicleTypes.size(); i++)
        {
            freeSpotsCount[vehicleTypes[i]] = 0;
        }

        // Count free spots for each vehicle type in the parking layout
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                int vehicleType = parking[i][j];
                if (vehicleType != 0) // If the spot is for a specific vehicle type
                {
                    freeSpotsCount[vehicleType]++;
                }
            }
        }
    }

    string park(int vehicleType)
    {
        int row = parking.size();
        int col = parking[0].size();
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (parking[i][j] == vehicleType && !reserved[i][j])
                {
                    reserved[i][j] = true;
                    freeSpotsCount[vehicleType]--;
                    return to_string(floor) + "-" + to_string(i) + "-" + to_string(j);
                }
            }
        }
        return "";
    }

    bool removeVehicle(int row, int col)
    {
        int vehicleType = parking[row][col];
        if (!reserved[row][col] || vehicleType == 0)
            return false;
        reserved[row][col] = false;
        freeSpotsCount[vehicleType]++;
        return true;
    }

    int getFreeSpotsCount(int vehicleType)
    {
        return freeSpotsCount[vehicleType];
    }
};

class SearchManager
{
public:
    unordered_map<string, string> cache; // vehiclenumber , ticketid

    string search(const string &query)
    {
        return cache.count(query) ? cache[query] : "";
    }

    void index(const string &spotId, const string &vehicleNumber, const string &ticketId)
    {
        cache[vehicleNumber] = spotId;
        cache[ticketId] = spotId;
    }
};

class ParkManager
{
public:
    string park(vector<ParkingFloor> &floors, int vehicleType, int parkingStrategy)
    {
        if (parkingStrategy == 0)
        {
            return parkNearest(floors, vehicleType);
        }
        else if (parkingStrategy == 1)
        {
            return parkMostFreeSpots(floors, vehicleType);
        }
        return "";
    }

private:
    string parkNearest(vector<ParkingFloor> &floors, int vehicleType)
    {
        for (auto &floor : floors)
        {
            string spotId = floor.park(vehicleType);
            if (!spotId.empty())
                return spotId;
        }
        return "";
    }

    string parkMostFreeSpots(vector<ParkingFloor> &floors, int vehicleType)
    {
        int maxFreeSpots = -1;
        int floorIndex = -1;
        for (int i = 0; i < floors.size(); i++)
        {
            int freeSpots = floors[i].getFreeSpotsCount(vehicleType);
            if (freeSpots > maxFreeSpots)
            {
                maxFreeSpots = freeSpots;
                floorIndex = i;
            }
        }

        if (floorIndex >= 0)
        {
            return floors[floorIndex].park(vehicleType);
        }
        return "";
    }
};

class Solution
{
private:
    vector<ParkingFloor> floors;
    SearchManager searchManager;
    ParkManager parkManager;

public:
    Solution(vector<vector<vector<int>>> &parking, vector<int> &vehicleTypes)
    {
        for (int i = 0; i < parking.size(); i++)
        {
            floors.push_back(ParkingFloor(i, parking[i], vehicleTypes));
        }
    }

    string park(int vehicleType, const string &vehicleNumber, const string &ticketId, int parkingStrategy)
    {
        string spotId = parkManager.park(floors, vehicleType, parkingStrategy);
        if (!spotId.empty())
        {
            searchManager.index(spotId, vehicleNumber, ticketId);
        }
        return spotId;
    }

    bool removeVehicle(const string &spotId)
    {
        size_t pos1 = spotId.find('-');
        size_t pos2 = spotId.find('-', pos1 + 1);
        int floorIndex = stoi(spotId.substr(0, pos1));
        int row = stoi(spotId.substr(pos1 + 1, pos2 - pos1 - 1));
        int col = stoi(spotId.substr(pos2 + 1));
        return floors[floorIndex].removeVehicle(row, col);
    }

    int getFreeSpotsCount(int floor, int vehicleType)
    {
        return floors[floor].getFreeSpotsCount(vehicleType);
    }

    string searchVehicle(const string &query)
    {
        return searchManager.search(query);
    }
};

int main()
{
    vector<int> vehicleTypes = {2, 4}; // Vehicle types: 2 for bike, 4 for car
    vector<vector<vector<int>>> parking = {
        {{2, 4, 0}, {4, 0, 2}, {0, 2, 4}},
        {{4, 2, 0}, {0, 2, 4}, {4, 2, 0}}};

    Solution solution(parking, vehicleTypes);
    string spot = solution.park(4, "ABC123", "TICKET123", 1);
    cout << "Parked at: " << spot << endl;
    cout << "Free spots on floor 0 for vehicle type 4: " << solution.getFreeSpotsCount(0, 4) << endl;
    solution.removeVehicle(spot);
    cout << "Free spots on floor 0 for vehicle type 4 after removal: " << solution.getFreeSpotsCount(0, 4) << endl;

    return 0;
}
