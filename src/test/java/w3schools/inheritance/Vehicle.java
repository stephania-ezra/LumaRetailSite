package w3schools.inheritance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Vehicle {
    public static Logger log = LogManager.getLogger(Vehicle.class);
    protected String brand = "Volvo";// attribute

    // protected modifier is used above
    //if private is used , Car class cannot inherit the attribute
    //method
    public void honk() {
        log.info("Beep Beep");
    }
}
