import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;



public class MasterLog {

    private double fare;
    private Coordinates start;
    private Coordinates end;
    private Driver driver;
    private Passenger passenger;
    private double balance;
    private double rating;
    private boolean tripCompleted;
    private Trip trip;
    JSONObject tripLog;
    public ArrayList<Trip> tripList;

    @SuppressWarnings("unchecked")

    public MasterLog(ArrayList<Trip> tripList) {
        this.tripList = tripList;
        this.trip = trip;
        tripLog = new JSONObject();
        JSONArray driverBalance = new JSONArray();

        writeDriverBalance(tripLog);
        writePassengerBalance(tripLog);
        writeDriverLocation(tripLog);
        writePassengerLocation(tripLog);
        writeNumTrips(tripLog);
        writeNumTransactions(tripLog);
        writeRatings(tripLog);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(tripLog);
        try {

            FileWriter file = new FileWriter("masterLog.txt");
            file.write(json);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(json);
    }

    public void writeDriverBalance(JSONObject j){
        JSONArray driverBalance = new JSONArray();
        for (Trip trip : tripList) {
            driverBalance.add(trip.getDriver().getName()+": $"+trip.getDriver().getBalance());
        }
        j.put("Driver balances", driverBalance);
    }
    public void writePassengerBalance(JSONObject j){
        JSONArray passengerBalance = new JSONArray();
        for (Trip trip : tripList) {
            passengerBalance.add(trip.getPassenger().getName()+": $"+trip.getPassenger().getBalance());
        }
        j.put("Passenger balances", passengerBalance);
    }

    public void writeDriverLocation(JSONObject j){
        JSONArray driver = new JSONArray();
        for (Trip trip : tripList) {
            driver.add(trip.getDriver().getName()+": "+trip.getDriver().getCoordinates().toString());
        }
        j.put("Driver locations ", driver);
    }

    public void writePassengerLocation(JSONObject j){
        JSONArray passenger = new JSONArray();
        for (Trip trip : tripList) {
            passenger.add(trip.getDriver().getName()+": "+trip.getDriver().getCoordinates().toString());
        }
        j.put("Passenger locations ", passenger);
    }

    public void writeNumTrips(JSONObject j) {
        j.put("Number of trips attempted ", tripList.size());
    }

    public void writeNumTransactions(JSONObject j) {
        int numSuccessful = 0;
        for (Trip trip: tripList){
            if (trip.isSuccess() == true){
                numSuccessful++;
            }
        }
        j.put("Number of transactions", numSuccessful);
    }

    public void writeRatings(JSONObject j){
        JSONArray ratings = new JSONArray();
        for (Trip trip : tripList) {
            ratings.add(trip.getDriver().getName()+": "+trip.getDriver().getRating().calculateRating());
        }
        j.put("Driver ratings ", ratings);
    }


}