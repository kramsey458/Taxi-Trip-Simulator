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
        timer.schedule(new RemindTask(), seconds * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            //System.out.println("Time's up!");
            trip.getPassenger().setCoordinates(trip.destination);
            trip.getDriver().setCoordinates(trip.destination);
            System.out.println("Arrived at destination");
            System.out.println(trip.getPassenger().getName() + " is at x: " + trip.getPassenger().coordinates.getxCoord() + ", y: " + trip.getPassenger().coordinates.getyCoord());
            timer.cancel(); //Terminate the timer thread
        }
    }
}