package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/***
 * 1. Check whether the given number is greater than 1
 * 2. check whether the number is divided by ( 1 and itself) use modulo operator
 * 3. if yes then it is prime
 *
 */
public class PrimeNumber {
    public static Logger log = LogManager.getLogger(PrimeNumber.class);

    public static void main(String[] args) {
        int number = 7;
        int count = 0;
        if (number > 1) {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                log.info("{} is a Prime Number", number);
            } else {
                log.info("{} is Not a Prime number", number);
            }
        } else {
            log.info(number + "is Not a Prime number");
        }
    }
}
