package interview.program;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * swapping of letters
 * Input - String Swap
 * Output - Stping Swar
 */
public class ReplaceBetweenCharString {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

    public static void main(String[] args) {

        String str = "String Swap";
        log.info("Before Swapping:{}", str);
        // swap r and p
        char[] letters = str.toCharArray();
        int indexP = str.indexOf('p');
        char rLetter = letters[2];

        char letterP = letters[indexP];
        //swapping the letters

        letters[2] = letterP;
        letters[indexP] = rLetter;

        log.info("Arrays.toString {} ", Arrays.toString(letters)); // [S, t, p, i, n, g,  , S, w, a, r]
        log.info("StringUtils.join {} ", StringUtils.join(letters, " ")); // [C@909217e
        //use String() method below to convert the swapped character array back to String array
        String s = new String(letters);
        //log.info("new String(letters) {}", s); // Stping Swar
        log.info("After Swapping:{}", s);
    }
}
