package interview.program.linear.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    }
}
