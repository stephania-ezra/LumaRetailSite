package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteWordInSentence {
    public static Logger log = LogManager.getLogger(CreateNewString.class);

    public static void main(String[] args) {
        DeleteWordInSentence dwis = new DeleteWordInSentence();
        dwis.deleteWord();
    }

    void deleteWord() {
        String s = "A RED SEED";
        log.info("Given String is:{}", s);
        //String w = s + ' ';
        s += ' ';
        String word = "";
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                if (!word.equals("RED")) {
                    newString = newString + word + " ";
                }
                word = "";
            }
        }
        log.info("String After The Deleted Word:{}", newString);
    }
}
