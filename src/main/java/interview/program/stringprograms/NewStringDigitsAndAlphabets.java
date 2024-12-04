package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 1. divide the given string into two
 * 2. one is for digit another is for character
 * 3. then u can concatenate both
 */
public class NewStringDigitsAndAlphabets {
    public static Logger log = LogManager.getLogger(NewStringDigitsAndAlphabets.class);

    String s = "NO26 Sound";
    String d = "";
    String n = "";
    String s1 = "";

    void createNewString() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                d = d + c;
            } else {
                n = n + c;
            }
        }
        s1 = d + n ;
        log.info("New String is:{}", s1);
    }

    public static void main(String[] args) {
        NewStringDigitsAndAlphabets nsdAA = new NewStringDigitsAndAlphabets();
        log.info("The given string is:{}", nsdAA.s);
        nsdAA.createNewString();
    }
}