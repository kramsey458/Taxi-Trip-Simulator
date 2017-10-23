import java.util.Timer;
import java.util.TimerTask;

public class ArrivalTimer {
    Timer timer;
    Trip trip;

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