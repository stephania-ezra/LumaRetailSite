package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Form new String with only the Upper case letters present in the given string
 */
public class NewString {
    public static Logger log = LogManager.getLogger(NewString.class);

    String s = "Its Simple";
    String nS = "";

    void createNewString(){
        for ( int i = 0; i <s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                nS = nS + c;
            }
        }
        log.info("The New String is:{}", nS);
    }
    public static void main(String[] args) {
        NewString ns = new NewString();
        log.info("The given string is:{}", ns.s);
        ns.createNewString();
    }
}
