package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RemovingWhiteSpace {
    public static Logger log = LogManager.getLogger(ConvertingToUpperFindChar.class);

    String s = "I love India";
    String ns = "";
    void removeSpace(){
        for ( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)){
                ns = ns + c;
            }
        }
        log.info("String after Removing WhiteSpace:{}", ns);
    }

    public static void main(String[] args) {
        RemovingWhiteSpace rws = new RemovingWhiteSpace();
        log.info("Given String is:{}", rws.s);
        rws.removeSpace();
    }
}
