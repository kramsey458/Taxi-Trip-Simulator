import java.util.concurrent.TimeUnit;

/**
 * Driver class. Creates map and populates it via tripReader. Then calls MasterLog to record trip history.
 */
public class UberSimulator {

    public static void main(String[] args) {
        Map newMap = new Map();
        TripReader t = new TripReader(newMap);
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
        }
        MasterLog m = new MasterLog(newMap.tripList);
    }
}

