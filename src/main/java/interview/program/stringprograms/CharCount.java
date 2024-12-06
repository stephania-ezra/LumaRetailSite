package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * Program to calculate the occurences of each letter
 * naveen automation lab - youtube video
 */
public class CharCount {
    public static Logger log = LogManager.getLogger(CharCount.class);

    HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();

    String s = "test";

    void getCharCount(){
     char[] strArray = s.toCharArray();
     for ( char c : strArray){
         if (charMap.containsKey(c)){
             charMap.put(c, charMap.get(c)+1);
         }else{
             charMap.put(c,1);
         }
     }
     log.info(charMap);
    }
    public static void main(String[] args) {
        CharCount cc = new CharCount();
        log.info("The given String is:{}", cc.s);
        cc.getCharCount();
    }
}
