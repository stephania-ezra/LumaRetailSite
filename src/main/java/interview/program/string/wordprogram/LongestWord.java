package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LongestWord {
    public static Logger log = LogManager.getLogger(WordsCount.class);

    String s = "My Name Collins is ";
    String w = s +" ";
    String word = "";
    String lw = "";

    void longWord() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                if(word.length() > lw.length()){ // 2 > 0
                    // 4 > 2
                    //7 > 4
                    //7 >  2
                    lw = word ; // lw = My
                    // lw = Name
                    // lw = Collins
                    // lw = Collins
                }
                word = "";
            }
        }
        log.info(lw);
    }

    public static void main(String[] args) {
        LongestWord lw = new LongestWord();
        lw.longWord();
    }
}


