package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubStringLearn {
    public static Logger log = LogManager.getLogger(SubStringLearn.class);

    public static void main(String[] args) {
        String s = "I love Java";
        //          01234567891
        //log.info(s.length());
        log.info(s.substring(7));
        log.info(s.substring(7,s.length()));
    }
}
