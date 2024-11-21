package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseString {

    public static Logger log = LogManager.getLogger(ReverseString.class);

    public static void main(String[] args) {

        //method 1 : using for loop
        /*String s = "ezra";
        int length = s.length(); //length is 5
        String reverse = "";

        for(int i=length-1; i>=0 ; i--){
            reverse = reverse + s.charAt(i);
            //first time reverse = n
            //second time reverse =na
            //third time reverse =nah
            //fourth time reverse = naht
            //fifth time reverse = nahte
        }
        log.info(reverse);*/

        //method 2 : using StringBuffer class
        String s = "ezra";
        StringBuffer sf = new StringBuffer(s);
        log.info(sf.reverse());
    }
}
