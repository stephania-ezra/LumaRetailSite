package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountNumberOfWords {
    public static Logger log = LogManager.getLogger(SearchWordInString.class);

    String s = "MOM OR OR DAD";
    String w = s + " "; // w = "MOM OR DAD ";
    String word = "";
    int count = 0;

    void countWords() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                count++;
            }
            word = "";
        }
        log.info("Number of words is: {} ", count);
    }

    public static void main(String[] args) {
        CountNumberOfWords cnow = new CountNumberOfWords();
        cnow.countWords();
    }
}


