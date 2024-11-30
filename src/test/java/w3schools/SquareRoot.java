package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SquareRoot {
    public static Logger log = LogManager.getLogger(SquareRoot.class);

    public static void main(String[] args) {
        //int x = 64;
        Scanner input = new Scanner(System.in);
        log.info("Enter the number for SquareRoot");

        int n = input.nextInt();
        log.info("Square Root is:{}", Math.sqrt(n));
    }
}
