/**
 * Represents rating for an uber driver
 */
public class Rating {

    private double totalStars;
    private double totalRates;

    public Rating(int stars, int rates) {
        this.totalStars = stars;
        this.totalRates = rates;
    }

    /**
     *
     * @return Driver rating based off total stars and total rates
     */
    public double calculateRating(){
        return totalStars/totalRates;
    }

    public double getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(double totalStars) {
        this.totalStars = totalStars;
    }

    public double getTotalRates() {
        return totalRates;
    }

    public void setTotalRates(double totalRates) {
        this.totalRates = totalRates;
    }
}
