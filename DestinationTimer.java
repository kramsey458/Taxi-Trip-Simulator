import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task
 * to execute once 5 seconds have passed.
 */

public class DestinationTimer {
    Timer timer;
    Trip trip;

    public DestinationTimer(int seconds, Trip trip) {
        timer = new Timer();
        this.trip = trip;
        timer.schedule(new DestinationArrived(), seconds * 100);
    }

    class DestinationArrived extends TimerTask {
        public void run() {
            trip.getPassenger().setCoordinates(trip.destination);
            trip.getDriver().setCoordinates(trip.destination);
            trip.getPassenger().rateDriver(trip.getDriver(), 5);
            trip.setSuccess(true);
            TripLogger tripLogger = new TripLogger(trip);
            timer.cancel();
        }
    }
}