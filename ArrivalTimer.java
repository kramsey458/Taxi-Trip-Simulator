import java.util.Timer;
import java.util.TimerTask;

public class ArrivalTimer {
    Timer timer;
    Trip trip;

    /**
     *
     * @param seconds The amount of time for the driver arrival to take
     * @param trip The trip object which is being simulated
     */
    public ArrivalTimer(int seconds, Trip trip) {
        timer = new Timer();
        this.trip = trip;
        timer.schedule(new DriverArrived(), seconds * 100);
    }

    class DriverArrived extends TimerTask {
        public void run() {
            trip.getDriver().setCoordinates(trip.getPassenger().getCoordinates());
            new DestinationTimer(trip.calculateDestinationTime(), trip);
            timer.cancel();
        }
    }
}