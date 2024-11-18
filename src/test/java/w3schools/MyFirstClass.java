package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyFirstClass {
    public static Logger log = LogManager.getLogger(MyFirstClass.class);

    public static void main(String[] args) {

        /*log.info("I am Stephania");
        log.info("Refreshing Java Concepts");
        log.info("It is awesome");

        log.info(3);
        log.info(3 + 3);
        log.info(5 * 5);

       String name = "Collins";
        log.info(name);

        int number = 10;
        log.info(number);

       int number = 12;
        number = 15; // reassigning the value
        log.info(number);

        final int num = 25;
        num = 30; //getting the error cannot assign a value to final variable
        log.info(num);*/

        int value = 10;
        char alphabet = 'A';
        String name = "Ethan";
        Boolean boo = true;
        float num = 2.0005f;

        //check with darli to print all these data types in a line . Is it possible?

        log.info(name);
        log.info(value);
        log.info(num);
        
    }
}
