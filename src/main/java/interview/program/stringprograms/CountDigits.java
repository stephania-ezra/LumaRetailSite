package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountDigits {
    public static Logger log = LogManager.getLogger(CountDigits.class);

    String s = "Collin123s Etha7n089";
    int countD = 0;
    void countDigits(){
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                countD++;
            }
        }
        log.info("count of digits is:{}", countD);
    }

    public static void main(String[] args) {
        CountDigits cd = new CountDigits();
        log.info("String is:{}", cd.s);
        cd.countDigits();
    }
}
