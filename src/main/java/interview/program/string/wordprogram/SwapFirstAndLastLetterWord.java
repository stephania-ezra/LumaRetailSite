package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * swapping first and last letter in each word
 */
public class SwapFirstAndLastLetterWord {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    String s = "In the box";
    String w = s + ' ';
    String word = "";
    String newString = "";

    public static void main(String[] args) {
        SwapFirstAndLastLetterWord sfallw = new SwapFirstAndLastLetterWord();
        sfallw.swapFirstLastLetter();
    }

    void swapFirstLastLetter() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
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
        log.info("New String is:{}", newString);
    }
}
