package w3schools.comparable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

// Define a Car class
class Car implements Comparable {
    public String brand;
    public String model;
    public int year;

    public Car(String b, String m, int y) {
        brand = b;
        model = m;
        year = y;
    }

    @Override
    public int compareTo(Object o) {
        Car other = (Car) o;
        if (year < other.year) return -1; // This object is smaller than the other one
        if (year > other.year) return 1;  // This object is larger than the other one
        return 0; // Both objects are the same
    }
}

public class CarModel2Comparable {

    public static Logger log = LogManager.getLogger(CarModel2Comparable.class);

    public static void main(String[] args) {
        // Create a list of cars
        ArrayList<Car> myCars = new ArrayList<Car>();
        myCars.add(new Car("BMW", "X5", 1999));
        myCars.add(new Car("Honda", "Accord", 2006));
        myCars.add(new Car("Ford", "Mustang", 1970));

        // Use a comparator to sort the cars
        Collections.sort(myCars);

        // Display the cars
        for (Car c : myCars) {
            log.info("{} {} {}", c.brand, c.model, c.year);
        }
    }
}
