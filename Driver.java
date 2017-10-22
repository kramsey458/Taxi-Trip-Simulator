//test comment mac
public class Driver{


    private String carTitle;
    private boolean occupied;
    private Rating rating;
    private double rank;
    private String name;
    private double balance;
    private Coordinates coordinates;
    private Map map;

    public Driver(String name, double balance, int x, int y, String CarTitle, boolean occupied, Map map){
        this.name = name;
        this.balance = balance;
        if ((x > 299 || x < 0) || (y > 299 || y < 0))
            this.coordinates = new Coordinates(0, 0);
        else
            this.coordinates = new Coordinates(x, y);
        this.map = map;
        this.carTitle = CarTitle;
        this.occupied = occupied;
        this.rating = new Rating(5,1 );
        map.addDriver(this);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
