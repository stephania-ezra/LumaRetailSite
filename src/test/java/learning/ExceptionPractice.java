package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionPractice {
    public static Logger log = LogManager.getLogger(ExceptionPractice.class);

    public static void main(String[] args) {
        int a = 10 , c;
        int b =0;
        try {
            c = a / b;
            log.info("value of c is:{}", c);
        } catch (ArithmeticException e) {
            log.info("ArithmeticException");
        }
        log.info("Welcome to Exception Learning");
    }
}
