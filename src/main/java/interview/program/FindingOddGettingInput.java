package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FindingOddGettingInput {

    public static Logger log = LogManager.getLogger(FindingOddGettingInput.class);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        log.info("Please enter a number:");

        Integer number = sc.nextInt();
        if (number % 2 == 0) {
            log.info("Number {} is an Even Number", number);
        } else {
            log.info("Number: {} is an Odd Number", number);
        }
    }
}
