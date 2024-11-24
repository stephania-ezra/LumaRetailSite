package w3schools.inheritance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Vehicle {

    public static Logger log = LogManager.getLogger(Vehicle.class);

    public static void main(String[] args) {
        Car c = new Car();
        c.honk();
        log.info("Brand name is:{}", c.brand);
    }
}
