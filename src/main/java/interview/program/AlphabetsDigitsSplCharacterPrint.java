package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlphabetsDigitsSplCharacterPrint {

    public static Logger log = LogManager.getLogger(AlphabetsDigitsSplCharacterPrint.class);

    public static void main(String[] args) {
        String str = "1ReGrowTech_2021@!";
        String num = "";
        String alpha = "";
        String spl = "";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                num = num + ch[i];
            } else if (Character.isLetter(ch[i])) {
                alpha = alpha + ch[i];
            } else {
                spl = spl + ch[i];
            }
        }
        log.info("Numbers in String:{}\nCharacters in String:{}\nSplCharacters in String:{}", num, alpha, spl);
    }
}
