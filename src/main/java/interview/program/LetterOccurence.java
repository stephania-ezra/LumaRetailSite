package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterOccurence {
    public static Logger log = LogManager.getLogger(LetterOccurence.class);

    public static void main(String[] args) {
        String s = "Einstein";
        int length = s.length();
        int afterRemoval = s.replace("E", "").length();// length after removing a
        int count = length - afterRemoval;

        log.info("Number of Occurrences of Letter e is:{}", count);
    }


}
