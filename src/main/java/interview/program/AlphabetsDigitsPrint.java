package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlphabetsDigitsPrint {

    public static Logger log = LogManager.getLogger(AlphabetsDigitsPrint.class);

    public static void main(String[] args) {
        String str = "abc123def456";
        String num = "";
        String alpha = "";

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                num = num + ch[i];
            } else if (Character.isLetter(ch[i])) {
                alpha = alpha + ch[i];
            }
        }
        log.info("Numbers in String:{}\nCharacters in String:{}", num, alpha);
    }
}
