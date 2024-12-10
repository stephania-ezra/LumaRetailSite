package interview.program.string.wordprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * I LIKE THIS PROGRAM :)
 */

public class SearchWordInString {
    public static Logger log = LogManager.getLogger(SearchWordInString.class);

    String s = "MOM OR OR DAD";
    String w = s + " "; // w = "MOM OR DAD ";
    String word = "";
    int count = 0;

    void searchWord() {
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                if (word.equalsIgnoreCase("OR")) {
                    count++;
                }
                word = "";
            }
        }
        if ( count ==0){
            log.info("Word not found");
        }else{
            log.info("Word is present by {} times ", count);
        }
    }

    public static void main(String[] args) {
        SearchWordInString swis = new SearchWordInString();
        swis.searchWord();
    }
}
