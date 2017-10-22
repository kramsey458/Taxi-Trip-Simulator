import java.util.*;


public class Map {

    public Passenger[][] miniMap;
    public ArrayList<Driver> driverList;
    public ArrayList<Passenger> passengerList;
    public Map() {
        this.miniMap = new Passenger[300][300];
        driverList = new ArrayList<Driver>();
        passengerList = new ArrayList<Passenger>();
    }

    public void clearArray( Passenger[][] map) {
        for (Passenger[] row: map)
            Arrays.fill(row, null);
        //System.out.println(Arrays.deepToString(miniMap));
    }


    public double calculateCost(Driver driver, Passenger passenger){
        return 1;
    }

    public void addDriver(Driver driver){
        miniMap[driver.coordinates.getxCoord()][driver.coordinates.getyCoord()] = driver;
        driverList.add(driver);
        System.out.println(driver.getName());
    }

    public void addPassenger(Passenger passenger){
        miniMap[passenger.coordinates.getxCoord()][passenger.coordinates.getyCoord()] = passenger;
        passengerList.add(passenger);
        System.out.println(passenger.getName());
    }

    public PriorityQueue<Driver> shortestDriver(Passenger passenger){
        double distance;
        PriorityQueue<Driver> driverQueue=new PriorityQueue<Driver>(driverList.size(), new DriverComparator());
        for (Driver driver : driverList) {
            if (driver.isOccupied() == false) {
                distance = driver.coordinates.calculateDistance(passenger.coordinates);
                //if (Math.abs(distance) < Math.abs(shortestDistance)){
                driver.setRank(Math.abs(distance));
                //shortestDistance = distance;
                driverQueue.add(driver);
                //}
            }
        }
        System.out.println("Closest " + driverQueue.peek().getName());
        return driverQueue;
    }

    public Trip requestRide(Passenger passenger, Coordinates destination) {
        PriorityQueue<Driver> driverQueue = shortestDriver(passenger);
        Driver assignedDriver = acceptRide(driverQueue);
        Trip passengerTrip = new Trip(destination, assignedDriver, passenger, "Nothing");
        double cost = passengerTrip.calculateCost();
        passenger.pay(cost, assignedDriver);
        RideTimer rideTimer = new RideTimer((int)(cost);
        return passengerTrip;
    }

    public Driver acceptRide(PriorityQueue<Driver> drivers){
        PriorityQueue<Driver> driverQueue = drivers;
        for (Driver driver : driverQueue) {
            if (driver.isOccupied() == false){
                return driver;
            }
        }
        return null;
    }


}
