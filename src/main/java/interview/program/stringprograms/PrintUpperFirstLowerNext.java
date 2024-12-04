package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintUpperFirstLowerNext {
    public static Logger log = LogManager.getLogger(PrintUpperFirstLowerNext.class);

    String s = "NO26 Sound";
    String u = "";
    String l = "";
    String ns = "";

    void upperFirstLowerNext(){
        for ( int i = 0 ; i <s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) {
                u = u + c;
            }
            if(Character.isLowerCase(c)) {
                l = l + c ;
            }
        }
        String ns = u + l;
        log.info("New String is:{}", ns);
    }

    public static void main(String[] args) {
        PrintUpperFirstLowerNext pufln = new PrintUpperFirstLowerNext();
        log.info("the given String is:{}", pufln.s);
        pufln.upperFirstLowerNext();
    }
}
