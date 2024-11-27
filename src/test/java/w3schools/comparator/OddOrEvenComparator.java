package w3schools.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class EvenOrOdd implements Comparator {
    public int compare(Object obj1, Object obj2) {
        Integer a = (Integer) obj1;
        Integer b = (Integer) obj2;

        // Check each number to see if it is even
        // A number is even if the remainder when dividing by 2 is 0
        boolean aIsEven = (a % 2) == 0;
        boolean bIsEven = (b % 2) == 0;

        if (aIsEven == bIsEven) {

            // If both numbers are even or both are odd then use normal sorting rules
            if (a < b) return -1;
            if (a > b) return 1;
            return 0;

        } else {

            // If a is even then it goes first, otherwise b goes first
            if (aIsEven) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

public class OddOrEvenComparator {
    public static Logger log = LogManager.getLogger(OddOrEvenComparator.class);

    public static void main(String[] args) {

        ArrayList<Integer> myNumbers = new ArrayList<Integer>();

        myNumbers.add(12);
        myNumbers.add(35);
        myNumbers.add(14);
        myNumbers.add(45);

        Comparator myComparator = new EvenOrOdd();
        Collections.sort(myNumbers, myComparator);

        for (int number : myNumbers) {
            log.info(number);
        }
    }
}
