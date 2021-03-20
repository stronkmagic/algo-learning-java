package leetcode;

import java.util.HashMap;

class UndergroundSystem {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }

    //store avg + times for station pair
    //store user checkIn id and time to update avg time
    HashMap<Integer, Passenger> passengerMap;
    HashMap<String, Route> avgMap;

    public UndergroundSystem() {
        avgMap = new HashMap<>();
        passengerMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!passengerMap.containsKey(id)) {
            Passenger passenger = new Passenger();
            passenger.checkIn(t, stationName);
            passengerMap.put(id, passenger);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (passengerMap.containsKey(id)) {
            Passenger passenger = passengerMap.get(id);
            passenger.checkout(t, stationName);
            String routeKey = passenger.start + passenger.end;
            Route route = avgMap.getOrDefault(routeKey, new Route(passenger.start,passenger.end));
            route.addTrip(passenger.checkIn, passenger.checkOut);
            avgMap.put(routeKey, route);
            passengerMap.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        return avgMap.get(startStation + endStation).getAverageTime();
    }

    static class Passenger {
        int checkIn;
        int checkOut;
        String start;
        String end;

        void checkIn(int checkIn, String start) {
            this.start = start;
            this.checkIn = checkIn;
        }

        void checkout (int checkOut, String end) {
            this.end = end;
            this.checkOut = checkOut;
        }
    }

    static class Route {
        String start;
        String end;
        int totalNumberOfTrips;
        long totalTimeSpentInTrips;

        public Route(String start, String end) {
            this.start = start;
            this.end = end;

        }

        double getAverageTime() {
            return (double) totalTimeSpentInTrips / totalNumberOfTrips;
        }

        void addTrip(int startTime, int endTime) {
            totalTimeSpentInTrips += endTime - startTime;
            totalNumberOfTrips++;
        }
    }
}
