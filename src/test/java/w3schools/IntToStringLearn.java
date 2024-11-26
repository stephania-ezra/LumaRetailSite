package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntToStringLearn {

    public static Logger log = LogManager.getLogger(IntToStringLearn.class);

    public static void main(String[] args) {
        Integer i = 1000;
        String str = i.toString();
        log.info("String is: {}", str);
        log.info("Length of the String is:{}", str.length());
    }
}
