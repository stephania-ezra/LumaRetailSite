package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * reversal of a string
 * palindrome of a string
 */
public class ReverseString {
    public static Logger log = LogManager.getLogger(ReverseString.class);

    String s ="Indhu Rebeka Vargese";
    String rev = "";

    void reverse(){
        for ( int i = 0; i <s.length(); i++){
            char c =  s.charAt(i);
            rev = c + rev;
            // rev = I
            //rev = sI
            //rev = hsI
            //rev = whsI
            //rev = awhsI
            //rev = rawhsI
            //rev = yrawhsI
            //rev = ayrawhsI
            //rev = R ayrawhsI
            //rev = aR ayrawhsI
            //rev = iaR ayrawhsI
        }
        log.info("Reverse of the String is:{}", rev);
        if(s.equalsIgnoreCase(rev)){
            log.info("The given String {} is palindrome", s);
        }else{
            log.info("The given String {} is not a palindrome", s);
        }
    }
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        log.info("Given string is:{}", rs.s);
        rs.reverse();
    }
}
