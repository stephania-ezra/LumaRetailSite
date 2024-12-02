package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * series : 0 1  1 2 3 5 8 13 21 34
 */
public class FibanocciSeries {

    public static Logger log = LogManager.getLogger(FibanocciSeries.class);

    public static void main(String[] args) {
        int n1 = 0, n2 = 1;
        int sum = 0;
        log.info("{} {}", n1, n2);

        for (int i = 2; i < 10; i++) {
            sum = n1 + n2;
            log.info("{}", sum);
            n1 = n2;
            n2 = sum;
        }
    }
}
// output is like 0 1
/**
 * 1
 * 2
 * 3
 * 5
 * 8
 * 13
 * 21
 * 34
 * i want this to be printed in one line
 * check with darli
 */




