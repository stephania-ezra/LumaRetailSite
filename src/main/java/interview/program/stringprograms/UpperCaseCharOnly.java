package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Printing only the UPPERCASE CHARACTERS in a given string

public class UpperCaseCharOnly {
    public static Logger log = LogManager.getLogger(UpperCaseCharOnly.class);

    String s = "Its Simple";

    void upperCaseChar(){
        for (int i = 0 ; i < s.length(); i++){
           char c = s.charAt(i);
           if (Character.isUpperCase(c)){
               log.info("UpperCase Character is:{}", c);
           }
        }
    }

    public static void main(String[] args) {

        UpperCaseCharOnly ucco = new UpperCaseCharOnly();
        log.info("String is:{}", ucco.s);
        ucco.upperCaseChar();
    }
}
