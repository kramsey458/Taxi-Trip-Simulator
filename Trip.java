/**
 * Represents to contents of an uber trip. Including driver, passenger, and destination
 */
public class Trip {

    Coordinates destination;
    private double fare;
    private double time;
    private Driver driver;
    private Passenger passenger;
    private String passengerRequest;
    private Coordinates tripStart;
    private double oldPassengerBalance;
    private double oldDriverBalance;
    private double oldRating;
    private boolean success;
    private double surchage;

    /**
     *
     * @param destination Target destination for passenger
     * @param driver Driver assigned to passenger
     * @param passenger Passenger requesting trip
     * @param passengerRequest Special requests from the passenger. Could be implemented in uberEats
     * @param tripStart Starting destination for the trip
     * @param surchage Additional surcharge cost added to trip fare
     */
    public Trip(Coordinates destination, Driver driver, Passenger passenger, String passengerRequest, Coordinates tripStart, double surchage) {
        this.destination = destination;
        this.driver = driver;
        this.passenger = passenger;
        this.passengerRequest = passengerRequest;
        this.tripStart = tripStart;
        this.oldDriverBalance = driver.getBalance();
        this.oldPassengerBalance = passenger.getBalance();
        this.oldRating = driver.getRating().calculateRating();
        this.success = false;
        this.surchage = surchage;
    }

    /**
     *
     * @param surchage Fixed amount to add to trip cost. Useful for uberEats implementation
     * @return Cost calculated from ride distance
     */
    public double calculateCost(double surchage){
        double pickupDistance = Math.abs(driver.getCoordinates().calculateDistance(passenger.getCoordinates()));
        double rideDistance = Math.abs(passenger.getCoordinates().calculateDistance(destination));
        double cost = ((pickupDistance + rideDistance) * .06)+surchage;
        fare = cost;
        return cost;
    }

    public Coordinates getTripStart() {
        return tripStart;
    }

    public void setTripStart(Coordinates tripStart) {
        this.tripStart = tripStart;
    }

    /**
     *
     * @return Time for driver to arrive to passenger. Based off pickup distance.
     */
    public int calculateArrivalTime(){
        double pickupDistance = Math.abs(driver.getCoordinates().calculateDistance(passenger.getCoordinates()));
        return (int)((pickupDistance * .02) + 1);
    }

    /**
     *
     * @return Time for driver to arrive to destination. Based off calculated ride distance
     */
    public int calculateDestinationTime(){
        double rideDistance = Math.abs(passenger.getCoordinates().calculateDistance(destination));
        return (int)((rideDistance * .02));
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getFare() {
        return fare;
    }

    public double getSurchage() {
        return surchage;
    }

    public void setSurchage(double surchage) {
        this.surchage = surchage;
    }

    public double getOldPassengerBalance() {
        return oldPassengerBalance;
    }

    public double getOldRating() {
        return oldRating;
    }

    public void setOldRating(double oldRating) {
        this.oldRating = oldRating;
    }

    public void setOldPassengerBalance(double oldPassengerBalance) {
        this.oldPassengerBalance = oldPassengerBalance;
    }

    public double getOldDriverBalance() {
        return oldDriverBalance;
    }

    public void setOldDriverBalance(double oldDriverBalance) {
        this.oldDriverBalance = oldDriverBalance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getTime() {
        return time;
    }

    public Coordinates getDestination() {
        return destination;
    }

    public void setDestination(Coordinates destination) {
        this.destination = destination;
    }

    public String getPassengerRequest() {
        return passengerRequest;
    }

    public void setPassengerRequest(String passengerRequest) {
        this.passengerRequest = passengerRequest;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
