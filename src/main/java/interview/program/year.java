package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Leap year calculation
 * 1. using normal for loop
 * 2. using enhanced for loop
 */

public class year {
    public static Logger log = LogManager.getLogger(year.class);

    public static void main(String[] args) {

        int[] years = {1990, 1991, 1992, 1993, 1994};

        /*for (int i = 0; i < years.length; i++) {
            if (years[i] % 4 == 0) {
                log.info("{} is a leap year", years[i]);
            } else {
                log.info("{} is not a leap year", years[i]);
            }
        }*/

        for (int year : years) {
            if (year % 4 == 0) {
                log.info("{}is a leap year", year);
            } else {
                log.info("{}is not a leap year", year);
            }
        }
    }
}
