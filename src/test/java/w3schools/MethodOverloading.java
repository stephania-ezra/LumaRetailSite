package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//using same method name
// passing different parameters
public class MethodOverloading {
    public static Logger log = LogManager.getLogger(MethodOverloading.class);

    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
        return x + y;
    }


    public static void main(String[] args) {
        int z = plusMethod(5, 3);
        double b = plusMethod(5.1, 3.1);
        log.info("Int Z is:{}", z);
        log.info("Double b is:{}", b);
    }
}
