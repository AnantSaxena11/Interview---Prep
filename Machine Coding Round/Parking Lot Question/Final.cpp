#include <bits/stdc++.h>
using namespace std;

enum class VehicleType
{
    CAR,
    BIKE,
    TRUCK
};

class Vehicle
{
private:
    string licencePlate;
    VehicleType type;

public:
    Vehicle(string licencePlate, VehicleType type)
    {
        this->licencePlate = licencePlate;
        this->type = type;
    }

    string getLicencePlate() const
    {
        return licencePlate;
    }

    VehicleType getType() const
    {
        return type;
    }

    string getTypeAsString() const
    {
        switch (type)
        {
        case VehicleType::CAR:
            return "Car";
        case VehicleType::BIKE:
            return "Bike";
        case VehicleType::TRUCK:
            return "Truck";
        default:
            return "Unknown";
        }
    }
};

class Ticket
{
private:
    Vehicle *vehicle;
    time_t parkTime;
    double cost;
    bool isPaid;

public:
    Ticket(Vehicle *vehicle)
    {
        this->vehicle = vehicle;
        this->parkTime = time(0); // Get current time
        this->cost = 0.0;
        this->isPaid = false;
    }

    void calculateCost()
    {
        // For simplicity, let's assume cost per hour
        time_t currentTime = time(0);
        double hoursParked = difftime(currentTime, parkTime) / 3600; // convert to hours
        double rate = 0.0;

        // Setting parking rates based on vehicle type
        switch (vehicle->getType())
        {
        case VehicleType::CAR:
            rate = 10.0; // $10 per hour
            break;
        case VehicleType::BIKE:
            rate = 5.0; // $5 per hour
            break;
        case VehicleType::TRUCK:
            rate = 20.0; // $20 per hour
            break;
        }

        // Calculate cost
        cost = hoursParked * rate;
    }

    void markAsPaid()
    {
        isPaid = true;
    }

    void displayTicket()
    {
        cout << "Ticket for Vehicle: " << vehicle->getLicencePlate() << endl;
        cout << "Vehicle Type: " << vehicle->getTypeAsString() << endl;
        cout << "Parking Duration: " << difftime(time(0), parkTime) / 3600 << " hours" << endl;
        cout << "Cost: $" << cost << endl;
        cout << (isPaid ? "Paid" : "Not Paid") << endl;
    }

    bool isPaidStatus()
    {
        return isPaid;
    }
};

class Slot
{
private:
    bool isAvailable;
    Vehicle *ParkedVehicle;
    VehicleType type;

public:
    Slot(VehicleType type) : isAvailable(true), ParkedVehicle(nullptr), type(type) {}

    bool getIsAvailable() const
    {
        return isAvailable;
    }

    bool addVehicle(Vehicle *Vehicle)
    {
        if (type != Vehicle->getType())
        {
            cout << "Vehicle Type Mismatch. This slot is for " << getTypeAsString() << "." << endl;
            return false;
        }
        if (!isAvailable)
        {
            cout << "Slot is not available." << endl;
            return false;
        }
        ParkedVehicle = Vehicle;
        isAvailable = false;
        cout << "Vehicle " << Vehicle->getLicencePlate() << " parked." << endl;
        return true;
    }

    bool removeVehicle(Ticket &ticket)
    {
        if (isAvailable)
        {
            cout << "Slot is already empty." << endl;
            return false;
        }
        ticket.calculateCost();
        ticket.displayTicket();
        ParkedVehicle = nullptr;
        isAvailable = true;
        return true;
    }

    string getTypeAsString() const
    {
        switch (type)
        {
        case VehicleType::CAR:
            return "Car";
        case VehicleType::BIKE:
            return "Bike";
        case VehicleType::TRUCK:
            return "Truck";
        default:
            return "Unknown";
        }
    }

    Vehicle *getParkedVehicle() const
    {
        return ParkedVehicle;
    }
};

class Floor
{
private:
    string floorcode;
    map<VehicleType, vector<Slot>> floorplan;

public:
    Floor(string floorcode, int capacityCar, int capacityBike, int capacityTruck)
    {
        this->floorcode = floorcode;

        // Predefine the slots for each vehicle type
        for (int i = 0; i < capacityCar; ++i)
            floorplan[VehicleType::CAR].emplace_back(VehicleType::CAR);
        for (int i = 0; i < capacityBike; ++i)
            floorplan[VehicleType::BIKE].emplace_back(VehicleType::BIKE);
        for (int i = 0; i < capacityTruck; ++i)
            floorplan[VehicleType::TRUCK].emplace_back(VehicleType::TRUCK);
    }

    bool parkVehicle(Vehicle *v)
    {
        VehicleType type = v->getType();
        for (Slot &slot : floorplan[type])
        {
            if (slot.getIsAvailable())
            {
                return slot.addVehicle(v);
            }
        }
        cout << "No available slot for " << v->getTypeAsString() << " on this floor." << endl;
        return false;
    }

    void showAvailableSlots() const
    {
        cout << "Available slots on floor " << floorcode << ":\n";
        for (auto &entry : floorplan)
        {
            VehicleType type = entry.first;
            cout << typeToString(type) << " slots: ";
            bool found = false;
            for (const Slot &slot : entry.second)
            {
                if (slot.getIsAvailable())
                {
                    cout << "Available ";
                    found = true;
                }
            }
            if (!found)
                cout << "No available slots";
            cout << endl;
        }
    }

    string typeToString(VehicleType type) const
    {
        switch (type)
        {
        case VehicleType::CAR:
            return "Car";
        case VehicleType::BIKE:
            return "Bike";
        case VehicleType::TRUCK:
            return "Truck";
        default:
            return "Unknown";
        }
    }
};

class ParkingLot
{
private:
    string name;
    vector<Floor> buildingStructure;

public:
    ParkingLot(string name, vector<Floor> floors)
    {
        this->name = name;
        this->buildingStructure = floors;
    }

    bool parkVehicle(Vehicle *v)
    {
        for (Floor &floor : buildingStructure)
        {
            if (floor.parkVehicle(v))
                return true;
        }
        cout << "Parking lot full for vehicle " << v->getLicencePlate() << endl;
        return false;
    }

    void showAvailableSlots()
    {
        for (Floor &floor : buildingStructure)
        {
            floor.showAvailableSlots();
        }
    }
};

int main()
{
    // Create vehicles
    Vehicle car1("ABC123", VehicleType::CAR);
    Vehicle bike1("XYZ456", VehicleType::BIKE);
    Vehicle truck1("LMN789", VehicleType::TRUCK);
    Vehicle car2("ABC12", VehicleType::CAR);
    Vehicle bike2("XYZ56", VehicleType::BIKE);
    Vehicle truck2("LMN79", VehicleType::TRUCK);

    // Create floors with predefined slots
    Floor floor1("F1", 2, 3, 1); // 2 car slots, 3 bike slots, 1 truck slot
    Floor floor2("F2", 1, 2, 2); // 1 car slot, 2 bike slots, 2 truck slots

    // Create parking lot
    ParkingLot parkingLot("Lot A", {floor1, floor2});

    // Show available slots
    parkingLot.showAvailableSlots();

    // Park vehicles
    Ticket ticket1(&car1);
    Ticket ticket2(&bike1);
    Ticket ticket3(&truck1);
    Ticket ticket4(&car2);
    Ticket ticket5(&bike2);
    Ticket ticket6(&truck2);


    parkingLot.parkVehicle(&car1);
    parkingLot.parkVehicle(&bike1);
    parkingLot.parkVehicle(&truck1);
    parkingLot.parkVehicle(&car2);
    parkingLot.parkVehicle(&bike2);
    parkingLot.parkVehicle(&truck2);

    this_thread::sleep_for(std::chrono::seconds(2));
    // Show available slots again
    parkingLot.showAvailableSlots();


    // Remove vehicles and show tickets
    ticket1.calculateCost();
    ticket1.markAsPaid();
    ticket1.displayTicket();
    ticket2.calculateCost();
    ticket2.markAsPaid();
    ticket2.displayTicket();
    ticket3.calculateCost();
    ticket3.markAsPaid();
    ticket3.displayTicket();
    ticket4.calculateCost();
    ticket4.markAsPaid();
    ticket4.displayTicket();
    ticket5.calculateCost();
    ticket5.markAsPaid();
    ticket5.displayTicket();

    // Try to park another car (this should fail since the slots are full)
    Vehicle car3("DEF101", VehicleType::CAR);
    parkingLot.parkVehicle(&car2);

    return 0;
}
