package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrapperClassLearn {

    public static Logger log = LogManager.getLogger(WrapperClassLearn.class);

    public static void main(String[] args) {
        Integer i = 5;
        Character c = 'V';
        Boolean b = true;
        Double d = 5.99;

        log.info(i.intValue()); //intValue()
        log.info(c.charValue()); //charValue()
        log.info(b.booleanValue()); //booleanValue()
        log.info(d.doubleValue()); //doubleValue()s
    }
}
