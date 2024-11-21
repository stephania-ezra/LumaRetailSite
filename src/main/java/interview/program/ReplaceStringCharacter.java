package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ReplaceStringCharacter {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

   /* public static void main(String[] args) {
        String s = "ethan";

        char[] characters = s.toCharArray();
        int indexN = s.indexOf('a');
        char firstLetter = characters[0];
        char nLetter = characters[indexN];

        characters[0] = nLetter;
        characters[indexN] = firstLetter;

        for(char character:characters){
            log.info(" ---- " + character);
        }
    }*/

    public static void main(String[] args) {
        String str = "happy reading";

        char[] letters = str.toCharArray();
        //log.info(letters);
        int indexD = str.indexOf('d'); // 9
        char hLetter = letters[0]; // h

        //char dLetter = letters[9];// d
        // also can be written as
        char dLetter = letters[indexD];

        //swapping the letters
        letters[0] = dLetter;
        letters[indexD] = hLetter;

        for (char letter : letters) {
            log.info("<<<<{}", letter);
        }
    }

public String replaceFirstandLast(String s) {
        char[] characters = s.toCharArray();
        int indexLast = characters.length - 1;
        char firstLetter = characters[0];
        char LastLetter = characters[indexLast];

        characters[0] = LastLetter;
        characters[indexLast] = firstLetter;

        return String.valueOf(characters);
    }
}
