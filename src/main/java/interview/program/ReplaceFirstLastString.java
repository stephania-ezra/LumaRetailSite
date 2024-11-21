package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplaceFirstLastString {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

    public static void main(String[] args) {
        String s = "einstein";

       char[] letters = s.toCharArray();
       char first = s.charAt(0);
       int l = s.length();
       //getting last letter
       //char last = s.charAt(l-1);
       //getting last before letter
        char last = s.charAt(l-2);
       String mid = s.substring(1,l-1);
       String result = last+ mid +first;
       log.info(result); //iinsteen
    }
}
