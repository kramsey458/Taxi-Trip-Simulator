import java.util.*;

public class Map {

    public Driver[][] miniMap;
    private ArrayList<Driver> driverList;
    public Map() {
        this.miniMap = new Driver[300][300];
        driverList = new ArrayList<Driver>();
    }

    public void clearArray( Driver[][] map) {
        for (Driver[] row: map)
            Arrays.fill(row, null);
        System.out.println(Arrays.deepToString(miniMap));
    }

    public Driver calculateDriverMatch(Passenger client){
        return null;
    }

    public double calculateCost(Driver driver, Passenger passenger){
        return 1;
    }

    public void addDriver(Driver driver){
        miniMap[driver.coordinates.getxCoord()][driver.coordinates.getyCoord()] = driver;
        driverList.add(driver);
        System.out.println(driverList.get(0).getName());
    }




}
