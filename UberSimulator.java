//test driver 123456
public class UberSimulator {

    public static void main(String[] args){
        Map newMap = new Map();
        //newMap.clearArray(newMap.miniMap);
        Driver testDriver4 = new Driver("blake", 10, 299, 299,"camry", false, newMap);
        Driver testDriver = new Driver("boris", 10, 14, 14,"camry", false, newMap);
        Driver testDriver2 = new Driver("kyler", 10, 15, 15 ,"camry", false, newMap);
        Driver testDriver3 = new Driver("mac", 10, 100, 100 ,"camry", false, newMap);
        Passenger testPassenger = new Passenger("billy", 150, 15, 15, newMap);
        Passenger testPassenger2 = new Passenger("Lord choris", 150, 150, 150, newMap);
        /*
        testDriver2.rating.setTotalRates(5);
        testDriver2.rating.setTotalStars(25);
        testDriver.rating.setTotalStars(20);
        testDriver.rating.setTotalRates(5);
        /*
        newMap.addDriver(testDriver2);
        newMap.addDriver(testDriver3);
        newMap.addDriver(testDriver4);
        newMap.addDriver(testDriver);
        newMap.addPassenger(testPassenger);
        */
       // newMap.searchList(new Coordinates(testDriver.coordinates.getxCoord(), testDriver.coordinates.getyCoord()));
        Coordinates test = new Coordinates(100, 25);
        Coordinates test2 = new Coordinates(100, 50);
        //test.calculateDistance(test2);
        //newMap.requestRide(newMap.passengerList.get(0), new Coordinates(299, 299));
        testPassenger.requestRide(new Coordinates(299, 299));
        testPassenger2.requestRide(new Coordinates(5, 5));

    }
}
