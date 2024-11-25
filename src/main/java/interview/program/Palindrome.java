package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Palindrome {

    public static Logger log = LogManager.getLogger(Palindrome.class);

    public static void main(String[] args) {
        String name = "abba";
        String reverse = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }
        log.info("Given Name is:{}", name);
        log.info("Reverse Name is:{}", reverse);
        if (reverse.equals(name)) {
            log.info("The given name: {} is Palindrome", name);
        } else {
            log.info("The given name: {} is not a Palindrome", name);
        }
    }
}
