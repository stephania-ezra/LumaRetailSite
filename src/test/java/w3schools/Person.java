package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * use get , set method to access the private variable
 */
public class Person {
    public static Logger log = LogManager.getLogger(Encapsulation.class);

    public static void main(String[] args) {
        Encapsulation myObj = new Encapsulation();
        myObj.setName("David Goggins");
        log.info(myObj.getName());
    }
}
