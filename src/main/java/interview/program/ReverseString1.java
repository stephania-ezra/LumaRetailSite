package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseString1 {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

    public static void main(String[] args) {
        String originalStr = "Hello";
        String reversedStr = "";
        log.info("Original String is:{}", originalStr);

        int length = originalStr.length();
        log.info(length);// length = 5
        for (int i = 0; i < length; i++) {
            reversedStr = originalStr.charAt(i) + reversedStr;
            // first time reversedStr = H + null = H;
            // second time reversedStr = e+H => eH;
            // third time reveredStr = l + eH => leH;
            // fourth time reversedStr = l +leH => lleH;
            // fifth time reversedStr = o+ lleH => olleH
        }
        log.info(reversedStr);
    }
}


