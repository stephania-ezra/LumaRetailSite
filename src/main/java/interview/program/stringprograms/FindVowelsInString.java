package interview.program.stringprograms;

import interview.program.Vowels;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * finding the vowels
 * finding the count of the vowels
 * finding the consonants
 */
public class FindVowelsInString {
    public static Logger log = LogManager.getLogger(FindVowelsInString.class);

    String s = "encyclopedia";
    int countV = 0;
    int countC = 0;

    void findVowels(){
        for ( int i =0 ; i < s.length(); i ++){
            char c = s.charAt(i);
            char u = Character.toUpperCase(c);
            if (u == 'A'|| u == 'E' || u == 'I' || u == 'O' || u == 'U'){
                log.info("Vowels in the String are:{}", u);
                countV++;
            }else{
                if( u >= 'A' && u <='Z'){
                    log.info("Consonants in the String are:{}", u);
                    countC++;
                }
            }
        }
        log.info("Count of the Vowels are:{}", countV);
        log.info("Count of the Consonants are:{}", countC);
    }
    public static void main(String[] args) {
        FindVowelsInString fvis = new FindVowelsInString();
        log.info("String is:{}", fvis.s);
        fvis.findVowels();
    }
}
