package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseString1 {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

    public static void main(String[] args) {
        String originalStr = "Hello";
        String reversedStr = "";
        log.info("Original String is:{}", originalStr);

       int length= originalStr.length();
       log.info(length);
       for(int i=0;i<length;i++){
           reversedStr = originalStr.charAt(i) +reversedStr; //h eh leh lleh olleh
       }
        log.info(reversedStr);
    }
}


