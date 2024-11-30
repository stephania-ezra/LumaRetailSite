package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PositiveOrNegative {
    public static Logger log = LogManager.getLogger(PositiveOrNegative.class);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);
        numbers.add(0);
        numbers.add(100);
        numbers.add(-2);
        numbers.add(3);

        for (Integer number : numbers) {
            if (number != 0) {
                if (number > 0) {
                    log.info("Number {} is Positive Number", number);
                } else {
                    log.info("Number {} is Negative Number", number);
                }
            }
        }
    }
}
