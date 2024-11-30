package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RandomNumber {
    public static Logger log = LogManager.getLogger(RandomNumber.class);

    public static void main(String[] args) {
        log.info("Square Root is:{}", Math.random());
    }
}
