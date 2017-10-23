import java.util.concurrent.TimeUnit;

public class UberSimulator {

    public static void main(String[] args) {
        Map newMap = new Map();
        /*
        Driver testDriver4 = new Driver("blake", 10, 299, 299, "camry", false, newMap);
        //Driver testDriver = new Driver("boris", 10, 14, 14,"camry", false, newMap);
        Driver testDriver2 = new Driver("kyler", 10, 15, 15, "camry", false, newMap);
        Driver testDriver3 = new Driver("mac", 10, 15, 15, "camry", false, newMap);
        */
        TripReader t = new TripReader(newMap);
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
        }

        System.out.println(newMap.tripList.size());
        MasterLog m = new MasterLog(newMap.tripList);
    }
}

