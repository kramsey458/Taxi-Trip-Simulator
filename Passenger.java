import java.util.PriorityQueue;

public class Passenger {

    private String name;
    private double balance;
    private Coordinates coordinates;


    public Passenger(String name, double balance, int x, int y, Map map) {
        this.name = name;
        this.balance = balance;
        if ((x > 299 || x < 0) || (y > 299 || y < 0))
            this.coordinates = new Coordinates(0, 0);
        else
            this.coordinates = new Coordinates(x, y);
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double pay(double cost, Driver other) {
        this.balance -= cost;
        other.setBalance(other.getBalance() + (cost*.8));
        return this.getBalance();
    }
    public Trip requestRide(Coordinates destination, Map map) {
        int surchage = 3;
        if ((destination.getxCoord() > 299 || destination.getxCoord() < 0) || (destination.getyCoord() > 299 || destination.getyCoord() < 0)){
            return null;
        }
        PriorityQueue<Driver> driverQueue = map.shortestDriver(this);
        Driver assignedDriver = map.acceptRide(driverQueue);
        if (assignedDriver == null) {
            Driver dummyDriver = new Driver("No drivers were available", 0, 0, 0, "not valid", false, map);
            Trip passengerTrip = new Trip(destination, dummyDriver, this, "Nothing", this.getCoordinates(), surchage);
            passengerTrip.setSuccess(false);
            TripLogger tripLogger = new TripLogger(passengerTrip);
            map.tripList.add(passengerTrip);
            return null;
        }
        Trip passengerTrip = new Trip(destination, assignedDriver, this, "Nothing", this.getCoordinates(), surchage);
        map.tripList.add(passengerTrip);
        double cost = passengerTrip.calculateCost(3);
        if (passengerTrip.getPassenger().getBalance() - cost < 0) {
            passengerTrip.setSuccess(false);
            passengerTrip.getDriver().setOccupied(false);
            TripLogger tripLogger = new TripLogger(passengerTrip);
            map.tripList.add(passengerTrip);
            return null;
        }
        this.pay(cost, assignedDriver);
        ArrivalTimer arrivalTimer = new ArrivalTimer(passengerTrip.calculateArrivalTime(), passengerTrip);
        return passengerTrip;
    }

    public double rateDriver(Driver driver, int stars) {
        driver.getRating().setTotalStars(driver.getRating().getTotalStars() + stars);
        driver.getRating().setTotalRates(driver.getRating().getTotalRates()+1);
        return driver.getRating().calculateRating();
    }
}
