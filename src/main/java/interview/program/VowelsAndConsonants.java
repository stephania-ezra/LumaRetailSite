package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VowelsAndConsonants {
    public static Logger log = LogManager.getLogger(VowelsAndConsonants.class);

    public static void main(String[] args) {
        int vowCount = 0;
        int conCount = 0;

        String str = "Collins";

        str = str.toLowerCase(); //this is a simple sentence
        for (int i = 0; i < str.length(); i++) {
            // checks whether a character is a vowel
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                //increase the vowel count
                vowCount++;
            }// check whether the character is a consonant
            else {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    //increase the consonant count
                    conCount++;
                }
            }
        }
        log.info("Number of Vowels:{} \n Number of Consonants:{}", vowCount, conCount);
    }
}
