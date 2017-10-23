import java.util.*;


public class Map {

    public ArrayList<Driver> driverList;
    public ArrayList<Passenger> passengerList;
    public ArrayList<Trip> tripList;
    public Map() {
        driverList = new ArrayList<Driver>();
        passengerList = new ArrayList<Passenger>();
        tripList = new ArrayList<Trip>();
    }

    public void addDriver(Driver driver){
        driverList.add(driver);
        //System.out.println(driver.getName());
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
        //System.out.println(passenger.getName());
    }

    public PriorityQueue<Driver> shortestDriver(Passenger passenger){
        double distance;
        PriorityQueue<Driver> driverQueue=new PriorityQueue<Driver>(driverList.size(), new DriverComparator());
        for (Driver driver : driverList) {
            if (driver.isOccupied() == false) {
                distance = driver.getCoordinates().calculateDistance(passenger.getCoordinates());
                driver.setRank(Math.abs(distance));
                driverQueue.add(driver);
            }
        }
        return driverQueue;
    }

    public Driver acceptRide(PriorityQueue<Driver> drivers){
        PriorityQueue<Driver> driverQueue = drivers;
        for (Driver driver : driverQueue) {
            if (driver.isOccupied() == false){
                driver.setOccupied(true);
                return driver;
            }
        }
        return null;
    }


}
