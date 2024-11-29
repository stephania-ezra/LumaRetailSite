package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * it works :)
 * try with name collin
 */

public class DivideStringNParts {
    public static Logger log = LogManager.getLogger(DivideStringNParts.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        log.info("Please Enter a String"); // helloworld
        String a = input.next();
        int len = a.length(); //10

        log.info("Please Enter number of parts");
        int noOfParts = input.nextInt(); // 5

        char[] c = a.toCharArray(); // [H, e, l, l, o, w, o, r, l, d]
        int parts = len / noOfParts; // 2
        int startPos = 0;
        int endPos = parts;
        do {
            char[] result = Arrays.copyOfRange(c, startPos, endPos); // Helloworld, 0, 2

            log.info("startPos {} , endPos {} is {}", startPos, endPos, Arrays.toString(result));
            startPos = endPos;
            endPos += parts;

            if (startPos < len && endPos > len) {
                endPos = len;
//                log.info("startPos {} , endPos {}", startPos, endPos);
            }
        } while (endPos <= len);


        int nl = len / noOfParts; //nl = 10/5 = 2;
        StringBuilder s;

//        if (len % n == 0) { //10%5 ==0
        for (int i = 0; i < noOfParts; i++) { // i = 0 ; i <5 ; i++
            s = new StringBuilder();
            for (int j = nl * i; j < (i + 1) * nl; j++) { // j =2*0 ; j<1*2 ;j++
                s.append(a.charAt(j)); // he
            }
            log.info(s.toString());
        }
//        } else {
//            log.info("cant be divided");
//        }
    }
}
