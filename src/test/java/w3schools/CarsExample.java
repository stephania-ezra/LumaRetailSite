package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarsExample {

    public static Logger log = LogManager.getLogger(CarsExample.class);

    String car = "";

    public static void main(String[] args) {
        CarsExample c = new CarsExample();
        // modify the attributes
        c.car = "Breeza";
        log.info("Car name is:{}", c.car);
    }
}

/**
 * Overriding existing values
 * <p>
 * declaring final
 * <p>
 * declaring final to String car
 * i want the car variable to be Audi
 * output - java: cannot assign a value to final variable car
 * <p>
 * declaring final to String car
 * i want the car variable to be Audi
 * output - java: cannot assign a value to final variable car
 * <p>
 * declaring final to String car
 * i want the car variable to be Audi
 * output - java: cannot assign a value to final variable car
 */
/*public class CarsExample {

    public static Logger log = LogManager.getLogger(CarsExample.class);

    String car = "Audi";

    public static void main(String[] args) {
        Cars c = new Cars();
        // modify the attributes
        c.car = "Breeza"; // car is now Breeza
        log.info("Car name is:{}", c.car);
    }
}*/

/**
 * declaring final to String car
 * i want the car variable to be Audi
 * output - java: cannot assign a value to final variable car
 */
/*public class CarsExample {

    public static Logger log = LogManager.getLogger(CarsExample.class);

    final String car = "Audi";

    public static void main(String[] args) {
        Cars c = new Cars();
        // modify the attributes
        c.car = "Breeza"; //
        log.info("Car name is:{}", c.car);
    }
}*/

