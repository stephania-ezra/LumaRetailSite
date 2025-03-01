package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateNewString {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    String s = "A RED SEED";
    String w = s + ' ';
    String word = "";
    String newString = "";

    public static void main(String[] args) {
        CreateNewString cns = new CreateNewString();
        cns.newStringCreation();
    }

    void newStringCreation() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                if (word.equals("RED")) {
                    newString = newString + "BLUE" + " ";
                } else {
                    newString = newString + word + " ";
                }
                word = "";
            }
        }
        log.info("New String is:{}", newString);
    }
}


