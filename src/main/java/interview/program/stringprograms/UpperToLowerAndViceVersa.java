package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * intresting program
 * convert lower to uppercase
 * upper to lowercase in one string itself
 */
public class UpperToLowerAndViceVersa {
    public static Logger log = LogManager.getLogger(CheckingAParticularChar.class);

    String s = "NO26 Sound";
    String r = "";


    void viceVersa(){
        for( int i = 0 ; i <s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                r = r + Character.toLowerCase(c);
            }else{
                r = r + Character.toUpperCase(c);
            }
        }
        log.info("New String is:{}", r);
    }

    public static void main(String[] args) {
        UpperToLowerAndViceVersa utlavv = new UpperToLowerAndViceVersa();
        log.info("The given String is:{}", utlavv.s);
        utlavv.viceVersa();
    }
}
