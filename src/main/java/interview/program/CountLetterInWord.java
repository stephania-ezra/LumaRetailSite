package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * input - einstein
 * output ::
 * Count of e is : 2
 * Count of i is :2
 * Count of n is : 2
 * Count of s is : 1
 * Count of t is : 1
 * I tried by myself :) ha ha
 */

public class CountLetterInWord {
    public static Logger log = LogManager.getLogger(CountLetterInWord.class);

    public static void main(String[] args) {

        String str = "einstein";
        int countOfe = 0;
        int countOfi = 0;
        int countOfn = 0;
        int countOfs = 0;
        int countOft = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'e':
                    countOfe++;
                    break;
                case 'i':
                    countOfi++;
                    break;
                case 'n':
                    countOfn++;
                    break;
                case 's':
                    countOfs++;
                    break;
                case 't':
                    countOft++;
                    break;
            }
        }
        log.info("Count of e is :{}\nCount of i is :{}\nCount of n is :{}\nCount of s is :{}" +
                "\nCount of t is :{}", countOfe, countOfi, countOfn, countOfs, countOft);
    }
}
