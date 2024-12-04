package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountUpperChar {
    public static Logger log = LogManager.getLogger(LetterOrDigit.class);

    String s = "Its Simple";
     int countU = 0 ;

    void countUpperChar(){
        for ( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) {
                log.info(c);
                countU = countU + 1;
            }
        }
        log.info("\"Count of UpperCase Letters is:{}", countU);
    }

    public static void main(String[] args) {
        CountUpperChar cuc = new CountUpperChar();
        log.info("String is:{}", cuc.s);
        cuc.countUpperChar();
    }
}
