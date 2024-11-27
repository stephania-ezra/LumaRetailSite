package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * 1. Getting the year from the user and calculating leap year
 */

public class LeapYear {
    public static Logger log = LogManager.getLogger(AlphabetsDigitsPrint.class);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        log.info("Enter year:");
        int year = sc.nextInt();
        if (year % 4 == 0) {
            log.info("{} is a Leap year", year);
        } else {
            log.info("{}is not a leap year", year);
        }
    }
}
