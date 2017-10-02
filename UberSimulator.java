public class UberSimulator {

    public static void main(String[] args){
        Map newMap = new Map();
        newMap.clearArray(newMap.miniMap);
        Driver testDriver = new Driver("bob", 10, 0, 0 ,"camry", false);
        newMap.addDriver(testDriver);
    }
}
