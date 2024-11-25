package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class HashSetInt {
    public static Logger log = LogManager.getLogger(HashSetInt.class);

    public static void main(String[] args) {

        HashSet<Integer> numbers = new HashSet<Integer>();

        numbers.add(4);
        numbers.add(6);
        numbers.add(8);
        //
        // Display which numbers between 1 and 10 are in the set
        for (int i = 1; i < 10; i++) {
            if (numbers.contains(i)) {
                log.info("number {} found in the Set", i);
            } else {
                log.info("number{} Not found in the Set", i);
            }
        }
    }
}
