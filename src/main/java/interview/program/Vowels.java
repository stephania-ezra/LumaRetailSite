package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Vowels {
    public static Logger log = LogManager.getLogger(Vowels.class);

    /**
     * 1. counting vowels in a string
     * 2. vowels present or not
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "cry";//e o e i a = 5
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a':   // count = 5
                    count++;
                    break;
                case 'e':
                    count++; // count = 1 count = 3
                    break;
                case 'i':
                    count++; // count = 4
                    break;
                case 'o':
                    count++; // count = 2
                    break;
                case 'u':
                    count++;
                    break;
            }
        }
        if (count == 0) {
            log.info("No vowels Present");
        } else {
            log.info("Count of vowels is: {}", count);
        }
    }
}
