package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Checking if the given string has number / numbers
 */
public class DigitsInString {
    public static Logger log = LogManager.getLogger(DigitsInString.class);

    String s = "Collin123s Etha7n089";
    void checkDigits(){
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                log.info(c);
            }
        }
    }

    public static void main(String[] args) {
        DigitsInString dis = new DigitsInString();
        log.info("String is:{}", dis.s);
        dis.checkDigits();
    }
}
