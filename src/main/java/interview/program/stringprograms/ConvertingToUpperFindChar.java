package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConvertingToUpperFindChar {
    public static Logger log = LogManager.getLogger(ConvertingToUpperFindChar.class);

    String s = "Its RSimple";
    void findChar(){
        for (int i = 0 ; i <s.length();i++){
            char c = s.charAt(i);
            char u = Character.toUpperCase(c);
            if ( u == 'R') {
                log.info("Letter {} is Present", u);
            }
        }
    }

    public static void main(String[] args) {
        ConvertingToUpperFindChar ctufc = new ConvertingToUpperFindChar();
        log.info("String is:{}", ctufc.s);
        ctufc.findChar();
    }
}
