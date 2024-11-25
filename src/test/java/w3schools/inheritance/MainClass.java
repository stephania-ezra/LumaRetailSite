package w3schools.inheritance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 class Vehicle {
    public static Logger log = LogManager.getLogger(Vehicle.class);
    protected String brand = "Volvo";// attribute

    // protected modifier is used above
    //if private is used , Car class cannot inherit the attribute
    //method
    void sound() {
        log.info("Beep Beep");
    }
}
class Car extends Vehicle{
}

public class MainClass{
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.sound();
    }
}
