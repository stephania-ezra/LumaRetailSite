package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


/**
 * using Scanner class to get input
 * // output -Enter User name
 * //moses
 * User name is: moses
 */

public class MyClass {
    public static Logger log = LogManager.getLogger(MyClass.class);

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        log.info("Enter User name ");

        String userName = obj.nextLine();
        log.info("User name is: {}", userName);
    }
}
