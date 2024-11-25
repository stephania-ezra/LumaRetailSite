package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListIntRevSorting {

    public static Logger log = LogManager.getLogger(AccessModifier.class);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(12);
        numbers.add(32);
        numbers.add(22);
        numbers.add(42);
        numbers.add(62);
        numbers.add(52);
        numbers.add(10);
        numbers.add(31);

        Collections.sort(numbers, Collections.reverseOrder()); // sort array in rev order
        for (int number : numbers) {
            log.info(number);
        }
    }
}
