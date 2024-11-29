package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountWords {
    public static Logger log = LogManager.getLogger(CountWords.class);

    public static void main(String[] args) {

        String str = "You are my Sunshine";
        int l = str.split("\\s").length;
        log.info(l);
    }
}
