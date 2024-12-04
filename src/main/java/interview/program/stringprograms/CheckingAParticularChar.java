package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckingAParticularChar {
    public static Logger log = LogManager.getLogger(CheckingAParticularChar.class);

String s = "Its Simple";

void checkChar() {
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == 'm' || c == 'M') {
            log.info("Character {} is present", c);
        }
    }
}

    public static void main(String[] args) {
        CheckingAParticularChar capc =  new CheckingAParticularChar();
        log.info("String is:{}", capc.s);
        capc.checkChar();
    }
}
