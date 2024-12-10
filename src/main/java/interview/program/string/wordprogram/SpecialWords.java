package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Special words means : word with same starting and ending letter.
 * input -> "MOM OR DAD "
 * output -> MOM
 * DAD
 */
public class SpecialWords {
    public static Logger log = LogManager.getLogger(SpecialWords.class);

    String s = "MOM OR DAD";
    String w = s + " "; // w = "MOM OR DAD ";
    // adding space to the string so that the last word will be printed
    String word = "";

    void specialWord() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                char first = word.charAt(0);//M
                char last = word.charAt(word.length() - 1); //word.charAt(2) = M
                if (Character.toUpperCase(last) == Character.toUpperCase(first)) {
                    log.info(word);
                }
                word = ""; // print the word = "" here ; it works :)
            }
        }
    }

    public static void main(String[] args) {
        SpecialWords sc = new SpecialWords();
        sc.specialWord();
        log.info(sc.w.length());
    }
}


