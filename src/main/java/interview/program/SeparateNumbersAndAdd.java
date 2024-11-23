package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Input = Collins123
 * Output = 1+2+3 =6
 */

// ******Steps******
//1. Assume total of the digits = 0
//2. get the length of the string and iterate
//3. inside the loop , fetch each char value and store
//4 check if the character is digit or not , by using isDigit()
//5.if it is a digit , get the numerical value and add it to total
//total = total+numericvalue;

public class SeparateNumbersAndAdd {

    public static Logger log = LogManager.getLogger(AlphabetsDigitsPrint.class);

    public static void main(String[] args) {

        String str = "qw34544870jdfdc67890";
        log.info("Given String is:{}", str);

        int total = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char character = str.charAt(i);
            if (Character.isDigit(character)) {
                total = total + Character.getNumericValue(character);
            }
        }
        log.info("Total of the Numbers in the String:{}", total);
    }
}
