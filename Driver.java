//test comment mac
public class Driver extends Passenger{


    private String carTitle;
    private boolean occupied;
    private Rating rating;
    private double rank;

    /**
     *
     * @param name Driver name
     * @param balance Starting balance
     * @param x Starting x
     * @param y Starting y
     * @param CarTitle Name of drivers car
     * @param occupied Is driver available for uber rides?
     * @param map Map driver is bound to
     */
    public Driver(String name, double balance, int x, int y, String CarTitle, boolean occupied, Map map){
        super(name, balance, x, y,map);
        this.carTitle = CarTitle;
        this.occupied = occupied;
        this.rating = new Rating(5,1 );
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getCarTitle() {
        return carTitle;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

}
