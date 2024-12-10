package interview.program.string.wordprogram;

import interview.program.AlphabetsDigitsPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * check with darli
 */
public class WordsCount {
    public static Logger log = LogManager.getLogger(WordsCount.class);

    String s = "My Name is Collins";
    String w = s+' ';
    String word = "";

    void countWord(){
        for ( int i =0 ; i <w.length(); i++){
           char c = w.charAt(i);
           if(c != ' '){
               word+= c;
           }else{
               if(word.length()==2) {
                   log.info(word);
               }
               word = "";
           }
        }
    }

    public static void main(String[] args) {
        WordsCount wc = new WordsCount();
        wc.countWord();
    }
}
/**
 * Different possibilities / String functions that we can use
 * 1. w.charAt(0) --> first character of each word
 * 2. w.substring(0,2) ---> first two characters of each word
 * 3. w.startsWith("R") -> gives only the word starting with R
 * 4. w.endsWith("ED") -> gives the word ends with ED
 * 5. w.contains("E") -> gives all the words that contains letter E
 * 6. w.length()==3 --> gives the words that has 3 letters in the sentence
 * 7.
 */