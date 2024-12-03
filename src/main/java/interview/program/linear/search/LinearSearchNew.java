package interview.program.linear.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Linear search in just normal main function
 * check with Darli for this linear search
 */

public class LinearSearchNew {
    public static Logger log = LogManager.getLogger(LinearSearchNew.class);

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4};
        int target = 9;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                log.info("target is {} on position {}", target, i);
            }
        }
        //LinearSearchNew nsw = new LinearSearchNew();
        //nsw.search();
    }
/**
 * darli's attempt
 */
   /* void search() {
        int[] arr = {1, 3, 5, 7, 9, 2, 4};
        int target = 9;

        AtomicInteger count = new AtomicInteger(0);
        IntStream intStream = Arrays.stream(arr)
                .filter(value -> {
                    if (value == target) {
                        count.getAndIncrement();
                        return true;
                    } else
                        return false;
                });
        System.out.println("intStream" + intStream);
    }*/
}
