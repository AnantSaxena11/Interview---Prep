import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class Helper {
    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}

class ParkingResult {
    int status;
    String spotId;
    String vehicleNumber;
    String ticketId;

    public ParkingResult(int status, String spotId, String vehicleNumber, String ticketId) {
        this.status = status;
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
    }
}

class Spot {
    final String spotId;
    final AtomicBoolean occupied;

    Spot(String spotId) {
        this.spotId = spotId;
        this.occupied = new AtomicBoolean(false);
    }
}

class Solution {
    private Helper helper;
    private List<Spot> twoWheelerSpots = new ArrayList<>();
    private List<Spot> fourWheelerSpots = new ArrayList<>();
    private ConcurrentHashMap<String, String> vehicleToSpot = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> ticketToSpot = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Spot> spotIdToSpot = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ParkingDetails> spotToDetails = new ConcurrentHashMap<>();

    private static class ParkingDetails {
        String vehicleNumber;
        String ticketId;

        ParkingDetails(String vehicleNumber, String ticketId) {
            this.vehicleNumber = vehicleNumber;
            this.ticketId = ticketId;
        }
    }

    public void init(Helper helper, String[][][] parking) {
        this.helper = helper;
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                for (int k = 0; k < parking[i][j].length; k++) {
                    String spotInfo = parking[i][j][k];
                    String[] parts = spotInfo.split("-");
                    int type = Integer.parseInt(parts[0]);
                    boolean active = parts[1].equals("1");
                    if (active) {
                        String spotId = i + "-" + j + "-" + k;
                        Spot spot = new Spot(spotId);
                        spotIdToSpot.put(spotId, spot);
                        if (type == 2) {
                            twoWheelerSpots.add(spot);
                        } else if (type == 4) {
                            fourWheelerSpots.add(spot);
                        }
                    }
                }
            }
        }
    }

    public ParkingResult park(int vehicleType, String vehicleNumber, String ticketId) {
        List<Spot> spots = (vehicleType == 2) ? twoWheelerSpots : fourWheelerSpots;
        for (Spot spot : spots) {
            if (spot.occupied.compareAndSet(false, true)) {
                vehicleToSpot.put(vehicleNumber, spot.spotId);
                ticketToSpot.put(ticketId, spot.spotId);
                spotToDetails.put(spot.spotId, new ParkingDetails(vehicleNumber, ticketId));
                return new ParkingResult(201, spot.spotId, vehicleNumber, ticketId);
            }
        }
        return new ParkingResult(404, "", vehicleNumber, ticketId);
    }

    public int removeVehicle(String spotId, String vehicleNumber, String ticketId) {
        String targetSpotId = "";
        if (!spotId.isEmpty()) {
            targetSpotId = spotId;
        } else if (!vehicleNumber.isEmpty()) {
            targetSpotId = vehicleToSpot.getOrDefault(vehicleNumber, "");
        } else if (!ticketId.isEmpty()) {
            targetSpotId = ticketToSpot.getOrDefault(ticketId, "");
        }

        if (targetSpotId.isEmpty()) {
            return 404;
        }

        Spot spot = spotIdToSpot.get(targetSpotId);
        if (spot == null) {
            return 404;
        }

        if (spot.occupied.get()) {
            ParkingDetails details = spotToDetails.get(targetSpotId);
            if (!spotId.isEmpty()) {
                if (spot.occupied.compareAndSet(true, false)) {
                    return 201;
                }
            } else if (!vehicleNumber.isEmpty()) {
                if (details != null && vehicleNumber.equals(details.vehicleNumber) && spot.occupied.compareAndSet(true, false)) {
                    return 201;
                }
            } else if (!ticketId.isEmpty()) {
                if (details != null && ticketId.equals(details.ticketId) && spot.occupied.compareAndSet(true, false)) {
                    return 201;
                }
            }
        }
        return 404;
    }

    public ParkingResult searchVehicle(String spotId, String vehicleNumber, String ticketId) {
        if (!spotId.isEmpty()) {
            ParkingDetails details = spotToDetails.get(spotId);
            if (details != null) {
                return new ParkingResult(201, spotId, details.vehicleNumber, details.ticketId);
            } else {
                return new ParkingResult(404, "", "", "");
            }
        } else if (!vehicleNumber.isEmpty()) {
            String foundSpotId = vehicleToSpot.get(vehicleNumber);
            if (foundSpotId != null) {
                ParkingDetails details = spotToDetails.get(foundSpotId);
                if (details != null && vehicleNumber.equals(details.vehicleNumber)) {
                    return new ParkingResult(201, foundSpotId, details.vehicleNumber, details.ticketId);
                }
            }
            return new ParkingResult(404, "", "", "");
        } else if (!ticketId.isEmpty()) {
            String foundSpotId = ticketToSpot.get(ticketId);
            if (foundSpotId != null) {
                ParkingDetails details = spotToDetails.get(foundSpotId);
                if (details != null && ticketId.equals(details.ticketId)) {
                    return new ParkingResult(201, foundSpotId, details.vehicleNumber, details.ticketId);
                }
            }
            return new ParkingResult(404, "", "", "");
        }
        return new ParkingResult(404, "", "", "");
    }

    public int getFreeSpotsCount(int floor, int vehicleType) {
        List<Spot> spots = (vehicleType == 2) ? twoWheelerSpots : fourWheelerSpots;
        int count = 0;
        for (Spot spot : spots) {
            String[] parts = spot.spotId.split("-");
            int spotFloor = Integer.parseInt(parts[0]);
            if (spotFloor == floor && !spot.occupied.get()) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        String[][][] parking = {{
                {"4-1", "4-1", "2-1", "2-0"},
                {"2-1", "4-1", "2-1", "2-1"},
                {"4-0", "2-1", "4-0", "2-1"},
                {"4-1", "4-1", "4-1", "2-1"}
        }};

        Solution solution = new Solution();
        solution.init(helper, parking);

        ParkingResult pr = solution.park(4, "bh234", "tkt4534");
        helper.println("Park result: " + pr.status + " " + pr.spotId);

        ParkingResult search = solution.searchVehicle("", "bh234", "");
        helper.println("Search result: " + search.spotId + " " + search.vehicleNumber + " " + search.ticketId);

        int freeSpots = solution.getFreeSpotsCount(0, 4);
        helper.println("Free spots for 4-wheelers on floor 0: " + freeSpots);

        int removeStatus = solution.removeVehicle("", "bh234", "");
        helper.println("Remove status: " + removeStatus);

        freeSpots = solution.getFreeSpotsCount(0, 4);
        helper.println("Free spots after removal: " + freeSpots);
    }
}