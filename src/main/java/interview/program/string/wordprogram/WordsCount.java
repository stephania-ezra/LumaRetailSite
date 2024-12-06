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
