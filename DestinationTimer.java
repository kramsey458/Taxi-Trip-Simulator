import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 * Simulates time for driver to deliver passenger to destination
 */
public class DestinationTimer {
    Timer timer;
    Trip trip;

    /**
     *
     * @param seconds The number of seconds from passenger pickup to destination arrival
     * @param trip The trip object which we are simulating
     */
    public DestinationTimer(int seconds, Trip trip) {
        timer = new Timer();
        this.trip = trip;
        timer.schedule(new DestinationArrived(), seconds * 100);
    }

    class DestinationArrived extends TimerTask {
        public void run() {
            Random rand = new Random();
            trip.getPassenger().setCoordinates(trip.destination);
            trip.getDriver().setCoordinates(trip.destination);
            trip.getPassenger().rateDriver(trip.getDriver(), rand.nextInt(5 - 1 + 1) + 1);
            trip.setSuccess(true);
            TripLogger tripLogger = new TripLogger(trip);
            timer.cancel();
        }
    }
}