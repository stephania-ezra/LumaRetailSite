package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindEvenOrOdd {
    public static Logger log = LogManager.getLogger(FindEvenOrOdd.class);

    public static void main(String[] args) {
        int i;
        log.info("Finding odd or Even Number");
        for (i = 2; i <= 100; i = i + 2) {
            log.info("Printing even numbers:{}", i);
        }
        for (i = 1; i <= 100; i = i + 2) {
            log.info("Printing odd numbers:{}", i);
        }
    }
}
