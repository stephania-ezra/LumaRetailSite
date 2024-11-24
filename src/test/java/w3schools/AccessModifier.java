package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Private = only be accessible within the class
 * <p>
 * u cant call method / variable from the other class
 */
public class AccessModifier {

    public static Logger log = LogManager.getLogger(AccessModifier.class);

    private final String firstName = "Ethan";
    private final String lastName = "Calvin";
    private final String emailId = "Collins.einstein@gmail.com";
    private final int year = 2016;

    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        log.info("First Name:" + am.firstName + " \n" + "Last Name:" + am.lastName + " \n " + "Email Id:" +
                am.emailId + " \n" + "Birth Year:" + am.year);
    }
}

