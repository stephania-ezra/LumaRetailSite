package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringWorDec7 {
    public static Logger log = LogManager.getLogger(StringWorDec7.class);

    public static void main(String[] args) {
        StringWorDec7 swd7 = new StringWorDec7();
        swd7.stringWords("My Favourite Book is Alchemist");
    }

    void stringWords(String s) {
        String word = "";
        s += ' '; // adding space to the end 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                log.info(word);
                word = "";
            }
        }
    }

}

