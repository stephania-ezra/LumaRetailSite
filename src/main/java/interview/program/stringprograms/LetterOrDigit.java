package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * printing letters and digits in a number
 */
public class LetterOrDigit {
    public static Logger log = LogManager.getLogger(LetterOrDigit.class);

    String s = "Co#li^123s E!ha/*089";

    void letterOrDigit(){
        for ( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                log.info(c);
            }
        }
    }

    public static void main(String[] args) {
        LetterOrDigit lod = new LetterOrDigit();
        log.info("String is:{}", lod.s);
        lod.letterOrDigit();
    }
}
