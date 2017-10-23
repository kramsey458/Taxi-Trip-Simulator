import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TripReader {

    private Map map;
    private int numTrips;

    public TripReader(Map map) {
        this.map = map;
        createDrivers();
        createPassengers();
    }
        public void createPassengers () {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        JSONObject obj;
        String fileName = "testPassengers.txt";
        //System.out.println(System.getProperty("user.dir"));
        String line = null;
        this.map = map;
        this.numTrips = 0;

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                json.add(obj);
                Random rn = new Random();
                int randomX = rn.nextInt(299);
                int randomY = rn.nextInt(299);

                String passengerName = (String) obj.get("name");
                long destinationX = (long) obj.get("xCoord");
                long destinationY = (long) obj.get("yCoord");
                long balance = (long) obj.get("balance");
                Passenger newPassenger = new Passenger(passengerName, balance, randomX, randomY, map);
                map.addPassenger(newPassenger);
                map.passengerList.get(map.passengerList.size() - 1).requestRide(new Coordinates((int) destinationX, (int) destinationY), map);
                numTrips++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void createDrivers () {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        JSONObject obj;
        String fileName = "testDrivers.txt";
        //System.out.println(System.getProperty("user.dir"));
        String line = null;
        this.map = map;
        //this.numTrips = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                json.add(obj);
                Random rn = new Random();
                int randomX = rn.nextInt(299);
                int randomY = rn.nextInt(299);

                String passengerName = (String) obj.get("name");
                String carTitle = (String) obj.get("carTitle");
                long balance = (long) obj.get("balance");
                //System.out.println(passengerName);
                //System.out.println(destinationX);
                Driver newDriver = new Driver(passengerName, balance, randomX, randomY, carTitle, false, map);
                map.addDriver(newDriver);
                //newPassenger.requestRide(new Coordinates((int)destinationX, (int)destinationY));
                //map.addPassenger(newPassenger);
                //map.passengerList.get(map.passengerList.size() - 1).requestRide(new Coordinates((int) destinationX, (int) destinationY), map);
                //numTrips++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getNumTrips() {
        return numTrips;
    }

    public void setNumTrips(int numTrips) {
        this.numTrips = numTrips;
    }
}

