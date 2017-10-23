import java.util.PriorityQueue;

public class Passenger {

    private String name;
    private double balance;
    private Coordinates coordinates;

    /**
     *
     * @param name Passenger name
     * @param balance Starting balance
     * @param x Starting x position
     * @param y Starting y position
     * @param map Map that the passenger is bound to
     */
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

    /**
     *
     * @param cost The ride fare
     * @param other Driver you want to pay
     * @return The new balance of the passenger, after payment has been made.
     */
    public double pay(double cost, Driver other) {
        this.balance -= cost;
        other.setBalance(other.getBalance() + (cost*.8));
        return this.getBalance();
    }

    /**
     *
     * @param destination The destination you want to go to.
     * @param map The map which contains the list of drivers and passengers
     * @return The trip object containing the specifics of the passengers request
     */
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
            return null;
        }
        this.pay(cost, assignedDriver);
        ArrivalTimer arrivalTimer = new ArrivalTimer(passengerTrip.calculateArrivalTime(), passengerTrip);
        return passengerTrip;
    }

    /**
     *
     * @param driver Driver you wish to rate
     * @param stars Number of stars you wish to give the driver
     * @return The new, calculated rating of the driver. Based off total starts/total rates
     */
    public double rateDriver(Driver driver, int stars) {
        driver.getRating().setTotalStars(driver.getRating().getTotalStars() + stars);
        driver.getRating().setTotalRates(driver.getRating().getTotalRates()+1);
        return driver.getRating().calculateRating();
    }
}
