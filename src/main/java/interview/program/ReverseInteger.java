package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseInteger {
    public static Logger log = LogManager.getLogger(AlphabetsDigitsPrint.class);

    public static void main(String[] args) {
        long num = 12345;
        long rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        log.info("Reverse number is:{}", rev);
    }
}
/**
 * 1st iteration
 * rev = 0+5 = 5
 * num = 12345/10 = 1234
 * ----------------------
 * rev = 5 , num = 1234
 * ----------------------
 * <p>
 * 2nd iteration
 * rev = 5*10 + 1234 % 10 = 50 + 4 = 54
 * num = 1234 / 10 = 123
 * -------------------------------------
 * rev = 54 , num = 123
 * -------------------------------------
 * <p>
 * 3rd Iteration
 * rev = 54 * 10 + 123 % 10 = 540 + 3 = 543
 * num = 123 / 10 = 12
 * ----------------------------------------
 * rev = 543 , num = 12
 * ----------------------------------------
 * <p>
 * 4th Iteration
 * rev = 543*10 + 12 % 10 = 5430 + 2 = 5432
 * num = 12 / 10 = 1
 * ----------------------------------------
 * rev = 5432 , num = 1
 * ----------------------------------------
 * <p>
 * 5th Iteration
 * rev = 5432 * 10 + 1 % 10 = 54320 + 1 = 54321
 * num = 1 /10 = 0
 * --------------------------------------------
 * rev = 54321 , num = 0
 * --------------------------------------------
 * when num =0 , condition terminates
 * :) nice program i liked it
 */

