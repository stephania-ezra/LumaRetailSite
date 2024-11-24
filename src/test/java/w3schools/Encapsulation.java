package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Encapsulation concept
 */
public class Encapsulation {
    public static Logger log = LogManager.getLogger(Encapsulation.class);
    private String name;

    //Get Method
    public String getName() {
        return name;
    }

    //Set Method
    public void setName(String newName) {
        this.name = newName;
    }
}
