package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CapitalizeEachWordInSen {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    String s = "my son ethan";
    String w = s + ' ';
    String word = "";
    String newString = "";

    public static void main(String[] args) {
        CapitalizeEachWordInSen cewis = new CapitalizeEachWordInSen();
        cewis.capitalizeEachWord();
    }

    void capitalizeEachWord() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                char f = word.charAt(0);
                f = Character.toUpperCase(f);
                newString = newString + f + word.substring(1) + " ";
                word = "";
            }
        }
        log.info("New String is:{}", newString);
    }
}
