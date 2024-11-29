package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseString {

    public static Logger log = LogManager.getLogger(ReverseString.class);

    public static void main(String[] args) {

        //method 1 : using for loop
        String s = "ritchie";
        int length = s.length(); //length is 7
        String reverse = "";

        for (int i = length - 1; i >= 0; i--) { // i = 7-1 = 6
            reverse = reverse + s.charAt(i);
            //first time reverse = null + e = reverse => e
            //second time reverse = e + i => ei
            //third time reverse = ei+ h => eih
            //fourth time reverse = eih +c => eihc
            //fifth time reverse = eihc + t => eihct
            //sixth time reverse = eihct + i => eihcti
            // seventh time reverse = eihcti + r => eihctir
        }
        log.info(reverse);

        //method 2 : using StringBuffer class
        /*String s = "ezra";
        StringBuffer sf = new StringBuffer(s);
        log.info(sf.reverse());*/
    }
}
