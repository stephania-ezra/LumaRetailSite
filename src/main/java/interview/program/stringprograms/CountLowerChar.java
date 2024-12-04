package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountLowerChar {
    public static Logger log = LogManager.getLogger(LetterOrDigit.class);

    String s = "Its Simple";
    int countl = 0 ;

    void countLowerChar(){
        for ( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)) {
                log.info(c);
                countl = countl + 1;
            }
        }
        log.info("\"Count of LowerCase Letters is:{}", countl);
    }

    public static void main(String[] args) {
        CountLowerChar clc = new CountLowerChar();
        log.info("String is:{}", clc.s);
        clc.countLowerChar();
    }
}
