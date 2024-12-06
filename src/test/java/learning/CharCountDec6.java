package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class CharCountDec6 {
    public static Logger log = LogManager.getLogger(CharCountDec6.class);

    HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
    String s = "Welcome";

    void charCount(){
        char[] strArr = s.toCharArray();
        for (char c : strArr){
            if(charMap.containsKey(c)){
                charMap.put( c, charMap.get(c)+1);
            }else{
                charMap.put( c,1);
            }
        }
        log.info(charMap);
    }
    public static void main(String[] args) {
        CharCountDec6 ccd6 = new CharCountDec6();
        log.info("Given String is:{}", ccd6.s);
        ccd6.charCount();
    }
}
