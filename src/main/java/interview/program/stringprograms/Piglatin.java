package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Piglatin {
    public static Logger log = LogManager.getLogger(Piglatin.class);

    String s = "CLEAR";
    String ps = "";
    void charCheck() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char u = Character.toUpperCase(c);
            if (u == 'A' || u == 'E' || u == 'I' || u == 'O' || u == 'U') {
                if (i == 0) {
                    ps = s+"WAY";
                    break;
                }else{
                    ps = s.substring(2)+s.substring(0,2)+"AY";
                    break;
                }
            }
        }
        log.info("Piglatin String:"+ps);
    }

    public static void main(String[] args) {
        Piglatin p = new Piglatin();
        p.charCheck();
    }
}
