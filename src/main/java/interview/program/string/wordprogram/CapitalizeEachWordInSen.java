package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CapitalizeEachWordInSen {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    public static void main(String[] args) {
        CapitalizeEachWordInSen cewis = new CapitalizeEachWordInSen();
        cewis.capitalizeEachWord();
    }

    void capitalizeEachWord() {
        String s = "my son ethan";
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
                f = Character.toUpperCase(f);
                newString = newString + f + word.substring(1) + " ";
                word = "";
            }
        }
        log.info("Capitalized Words in String is:{}", newString);
    }
}
