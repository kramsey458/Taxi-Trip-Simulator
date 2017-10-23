import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
/**
 * Logs each individual trip in the "tripLog+passengerName" format. Creates a file for each trip simulated.
 */
public class TripLogger {

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

    @SuppressWarnings("unchecked")
    public TripLogger(Trip trip) {
        this.trip = trip;
        tripLog = new JSONObject();
        writeStartCoord();
        writeEndCoord();
        writePassengerName();
        writeDriverName();
        writeFare();
        writeTripSuccess();
        writeNewDriverLocation();
        writeOldDriverBalance();
        writeNewDriverBalance();
        writeOldPassengerBalance();
        writeNewPassengerBalance();
        writeOldRating();
        writeUpdatedRating();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(tripLog);

        try {

            FileWriter file = new FileWriter("tripLog" + trip.getPassenger().getName() + ".json");
            file.write(json);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(json);
    }

    public void writeFare() {
        tripLog.put("Fare ", trip.getFare());
    }

    public void writePassengerName() {
        tripLog.put("Passenger name ", trip.getPassenger().getName());
    }

    public void writeDriverName(){
        tripLog.put("Driver Name ", trip.getDriver().getName());
    }

    public void writeStartCoord(){
        tripLog.put("Start ", trip.getTripStart().toString());

    }

    public void writeEndCoord(){
        tripLog.put("End ", trip.getDestination().toString());
    }

    public void writeNewDriverLocation(){
        tripLog.put("Driver Pos ", trip.getDriver().getCoordinates().toString());
    }

    public void writeOldDriverBalance(){
        tripLog.put("Previous driver balance ", trip.getOldDriverBalance());
    }
    public void writeNewDriverBalance(){
        tripLog.put("New driver balance ", trip.getDriver().getBalance());
    }

    public void writeOldPassengerBalance(){
        tripLog.put("Old passenger balance ", trip.getOldPassengerBalance());
    }

    public void writeNewPassengerBalance(){
        tripLog.put("New passenger balance ", trip.getPassenger().getBalance());
    }

    public void writeOldRating(){
        tripLog.put("Previous driver rating ", trip.getOldRating());
    }

    public void writeUpdatedRating(){
        tripLog.put("Updated driver rating ", trip.getDriver().getRating().calculateRating());
    }

    public void writeTripSuccess(){
        tripLog.put("Trip transaction made? ", trip.isSuccess());
    }

}