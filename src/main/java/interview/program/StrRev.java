package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * input -> encyclopedia
 * output -> aidepolcycne
 * this is a duplicate code of reversed string
 * for practice
 */

public class StrRev {

    public static Logger log = LogManager.getLogger(StrRev.class);

    public static void main(String[] args) {
        String str = "encyclopedia";
        log.info("Given String is:{}", str);

        log.info(str.length()); // 12
        String reverseString = "";

        for (int i = 0; i < str.length(); i++) {
            reverseString = str.charAt(i) + reverseString;
        }
        log.info("Reversed String is:{}", reverseString);

        // first time : reverseString = e + null => e
        // second time : reverseString = n + e => ne
        // third time : reverseString = c + ne => cne
        // fourth time :reverseString = y + cne => ycne
        // fifth time : reverseString = c + ycne => cycne
        // sixth time : reverseString = l + cycne => lcycne
        // seventh time: reverseString = o + lcycne => olcycne
        // eighth time : reverseString = p + olcycne => polcycne
        // ninth time : reverseString = e + polcycne => epolycycne
        //tenth time: reverseString = d + epolycycne => depolycycne
        // eleventh time : reverseString = i +depolycycne => idepolycycne
        //twelve time :reverseString = a +idepolycycne => aidepolycycne
    }
}
