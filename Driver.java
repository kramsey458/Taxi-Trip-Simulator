public class Driver extends Passenger{


    private String CarTitle;
    private boolean occupied;
    private Rating rating;

    public Driver(String name, double balance, int x, int y, String CarTitle, boolean occupied){
        super(name, balance, x, y);
        this.CarTitle = CarTitle;
        this.occupied = occupied;
        this.rating = new Rating(0,0 );
    }

    public String getCarTitle() {
        return CarTitle;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setCarTitle(String carTitle) {
        CarTitle = carTitle;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
