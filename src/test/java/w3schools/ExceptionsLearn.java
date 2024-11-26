package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionsLearn {

    public static Logger log = LogManager.getLogger(ExceptionsLearn.class);

    public static void main(String[] args) {
        int[] num = {1, 3, 5};
        try {
            log.info(num[10]);
        } catch (Exception e) {
            log.info("Element doesn't exist");
        }finally{
            log.info("Finally will b executed after try/catch regardless of the result");
        }
    }
}
