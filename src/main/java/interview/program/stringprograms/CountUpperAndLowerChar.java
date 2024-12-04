package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * counting upper and lower case characters in a string
 */
public class CountUpperAndLowerChar {
    public static Logger log = LogManager.getLogger(CountUpperAndLowerChar.class);

    String s = "Its Simple";
    int countU = 0 ;
    int countL = 0;

    void checkUpperAndLower(){
        for ( int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                countU++;
            }
            if (Character.isLowerCase(c)) {
                countL++;
            }
        }
        log.info("Count of UpperCase Letters is:{} \n Count of LowerCase Letters is:{}", countU, countL);
        }

    public static void main(String[] args) {
        CountUpperAndLowerChar cualc = new CountUpperAndLowerChar();
        log.info("Given String is:{}", cualc.s);
        cualc.checkUpperAndLower();
    }
}

