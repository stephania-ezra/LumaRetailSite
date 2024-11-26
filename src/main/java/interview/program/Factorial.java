package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factorial {

    public static Logger log = LogManager.getLogger(Factorial.class);

    public static void main(String[] args) {
        int number = 5;
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i; // fact = 1 || fact = 2 || fact = 2*3 =6 || fact = 6*4 = 24 || fact = 24* 5 =120
        }
        log.info("Factorial is :{}", fact);
    }
}
