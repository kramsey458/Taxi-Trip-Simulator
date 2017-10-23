public class Coordinates {

    private int xCoord;
    private int yCoord;

    public Coordinates(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public String toString() {
        return xCoord + "," + yCoord;
    }

    /**
     *
     * @param otherCoordinates Coordinates that you wish to compare to
     * @return Distance between two coordinates
     */
    public double calculateDistance (Coordinates otherCoordinates){
        double otherX = otherCoordinates.getxCoord();
        double otherY = otherCoordinates.getyCoord();
        double X = this.xCoord;
        double Y = this.yCoord;
        return Math.sqrt((Math.pow((otherX-X), 2)) + (Math.pow((otherY-Y), 2)));
    }
}
