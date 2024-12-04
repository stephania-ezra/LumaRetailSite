package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * printing only lowercase alphabets in a string
 * input - my Name is CollIns
 * output -myameisollns
 */


public class LowerCaseCharOnly {

    public static Logger log = LogManager.getLogger(LowerCaseCharOnly.class);

    String s = "my Name is CollIns";

    void lowerCaseChar(){
        for ( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLowerCase(c)){
                log.info(c);
            }
        }
    }

    public static void main(String[] args) {

        LowerCaseCharOnly lcco = new LowerCaseCharOnly();
        log.info("String is:{}", lcco.s);
        lcco.lowerCaseChar();
    }
}
