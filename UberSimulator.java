//test driver 123456
public class UberSimulator {

    public static void main(String[] args){
        Map newMap = new Map();
        newMap.clearArray(newMap.miniMap);
        Driver testDriver4 = new Driver("blake", 10, 299, 299,"camry", false);
        Driver testDriver = new Driver("boris", 10, 0, 0,"camry", false);
        Driver testDriver2 = new Driver("kyler", 10, 20, 20 ,"camry", false);
        Driver testDriver3 = new Driver("mac", 10, 100, 100 ,"camry", false);
        Passenger testPassenger = new Passenger("billy", 100, 10, 10);
        testDriver2.rating.setTotalRates(5);
        testDriver2.rating.setTotalStars(25);
        testDriver.rating.setTotalStars(20);
        testDriver.rating.setTotalRates(5);
        newMap.addDriver(testDriver2);
        newMap.addDriver(testDriver3);
        newMap.addDriver(testDriver4);
        newMap.addDriver(testDriver);
        newMap.addPassenger(testPassenger);
       // newMap.searchList(new Coordinates(testDriver.coordinates.getxCoord(), testDriver.coordinates.getyCoord()));
        Coordinates test = new Coordinates(100, 25);
        Coordinates test2 = new Coordinates(100, 50);
        test.calculateDistance(test2);
        newMap.shortestDriver(testPassenger);

    }
}
