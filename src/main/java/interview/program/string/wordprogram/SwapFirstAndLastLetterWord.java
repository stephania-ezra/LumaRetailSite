package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * swapping first and last letter in each word
 */
public class SwapFirstAndLastLetterWord {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    public static void main(String[] args) {
        SwapFirstAndLastLetterWord sfallw = new SwapFirstAndLastLetterWord();
        sfallw.swapFirstLastLetter();
    }

    void swapFirstLastLetter() {
        String s = "In the box";
        log.info("The Given String is:{}", s);
        //String w = s + ' ';
        s += ' ';
        String word = "";
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                char f = word.charAt(0);
                char l = word.charAt(word.length() - 1);
                String m = word.substring(1, word.length() - 1);
                newString = newString + l + m + f + " ";
                word = "";
            }
        }
        log.info("Swapped String is:{}", newString);
    }
}
