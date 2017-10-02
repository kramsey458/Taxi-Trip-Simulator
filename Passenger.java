public class Passenger {

    private String name;
    private double balance;
    public Coordinates coordinates;


    public Passenger(String name, double balance, int x, int y) {
        this.name = name;
        this.balance = balance;
        this.coordinates = new Coordinates(x, y);
    }

    public Driver requestRide(int xDest, int yDest){
        return null;
    }

    public String getName() {
        return name;
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
}
