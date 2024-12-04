package interview.program.stringprograms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class OccurenceLearn {
    public static Logger log = LogManager.getLogger(OccurenceLearn.class);

    public static void main(String[] args) {

        String str = "zoo"; // str.length = 3
        //str.length()-1 = 3-1 =2
        HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();

       for ( int i = str.length()-1 ; i >=0 ; i --){
           if (charCount.containsKey(str.charAt(i))){
               int count = charCount.get(str.charAt(i));
               charCount.put(str.charAt(i), ++count);
           }else{
               charCount.put(str.charAt(i),1);
           }
       }
        log.info(charCount);
    }
}
/** for ( int i = 2 ; i >= 0 ; i --)
 *  str.charAt(2 ) = o ; if ( charCount.str.charAt(2)
 *
 *
 *
 */
/