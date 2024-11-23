package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Reverse all the words in a String
 * Input - Good Morning
 * Output - dooG gninroM
 */
public class ReverseWordsInString {
    public static Logger log = LogManager.getLogger(ReverseString.class);

    // 1. Split the string in to multiple parts
    // 2. Store it in a string array
    // 3. Read each word and Perform reverse algorithm
    // 4. combine them into a single string

    public static void main(String[] args) {
        String originalStr = "Welcome to Java";
        log.info("Original String is: {}", originalStr); // Original String

        String[] words = originalStr.split(" "); // Splitting string into Multiple Words
        String reverseString = "";

        for (String word : words) { //getting each word from the array words ..say Welcome
            String reverseWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord = reverseWord + word.charAt(i);
            }
            log.info("Reversed word is: {}", reverseWord);
            reverseString = reverseString + reverseWord + " ";
        }
        log.info("Reverse String is: {}", reverseString);
    }
}
