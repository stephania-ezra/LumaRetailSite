package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Printing the ascii code of the alphabets
 * I 73
 * T 84
 * S 83
 *   32
 * S 83
 * I 73
 * M 77
 * P 80
 * L 76
 * E 69
 */
public class AsciiCodeChar {
    public static Logger log = LogManager.getLogger(StringChar.class);

    String s = "ITS SIMPLE";

    void asciiCode(){
        for (int i =0 ; i < s.length(); i++){
            char c = s.charAt(i);
            log.info("{} {}", c, (int) c);
        }
    }
    public static void main(String[] args) {

        AsciiCodeChar acc = new AsciiCodeChar();
        log.info("String is:{}", acc.s);
        acc.asciiCode();
    }
}
