package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        int n = input.nextInt(); // 5

        int nl = len / n; //nl = 10/5 = 2;
        String s;

        if (len % n == 0) { //10%5 ==0
            for (int i = 0; i < n; i++) { // i = 0 ; i <5 ; i++
                s = "";
                for (int j = nl * i; j < (i + 1) * nl; j++) { // j =2*0 ; j<1*2 ;j++
                    s = s + a.charAt(j); // he
                }
                log.info(s);
            }
        } else {
            log.info("cant be divided");
        }
    }
}
