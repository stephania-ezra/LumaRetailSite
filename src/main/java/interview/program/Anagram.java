package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * 1. get a string
 * 2. convert it to lowercase and get it in a character array
 * 3. sort the array
 * 4. get another string
 * 5. convert it to lowercase and get it in a character array
 * 6. sort the second array
 * 7. check if both the array is equal
 * 8. if it is equal , the given string is anagram
 * 9. else it is not an anagram
 */

public class Anagram {
    public static Logger log = LogManager.getLogger(Anagram.class);

    public static void main(String[] args) {
        String str1 = "Triangle";
        String str2 = "eclipse";

        char[] a = str1.toLowerCase().toCharArray();
        Arrays.sort(a);
        // After Sorting
        /*for (char s : a) {
            log.info("After Sorting first array: \n{}", s);
        }*/
        char[] b = str2.toLowerCase().toCharArray();
        Arrays.sort(b);
        /*for (char v : b) {
            log.info("After Sorting second array: \n{}", v);
        }*/
        if (Arrays.equals(a, b)) {
            log.info("Given String is anagram");
        } else {
            log.info("Given string is not a anagram");
        }
    }
}
