package w3schools.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 1. Comparator uses a user defined logic in sorting
 * 2.with Comparator we are sorting the second digit of all the numbers
 * 3.ascending order of second digit
 */

public class ArrayListComparator {

    public static Logger log = LogManager.getLogger(ArrayListComparator.class);

    public static void main(String[] args) {

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
/*//43 31 72 29 54 76 => 3 1 2 9 4 6 => 3 greater than 1 so swap
        => 1 3 2 9 4 6 =>  3 >2  =>  so swap
            => 1 2 3 9 4 6 => 9 > 4 so swap
            => 1 2 3 4 9 6 => 9 > 6 so swap
            => 1 2 3 4 6 9*/

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(43);
        numbers.add(31);
        numbers.add(72);
        numbers.add(29);
        numbers.add(54);
        numbers.add(76);

        Collections.sort(numbers, c);
        log.info(numbers);
    }
}
