package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * printing each character of the string in separate line
 * input - ITS SIMPLE
 * output : I
 * T
 * S
 *
 * S
 * I
 * M
 * P
 * L
 * E
 */


public class StringChar {
    public static Logger log = LogManager.getLogger(StringChar.class);

    String s = "ITS SIMPLE" ;
    void stringFunc() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            log.info(c);
        }
    }

    public static void main(String[] args) {

    StringChar s = new StringChar();
    s.stringFunc();
    }
}
