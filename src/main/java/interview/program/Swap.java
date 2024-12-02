package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Swap {

    public static Logger log = LogManager.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        /* log.info("Before Swapping a is:{}\n b is:{}", a, b);

        // logic 1 : creating a temp variable temp

        int temp = a;
        a = b;
        b = temp;
         log.info("After Swapping a is:{}\n b is:{}", a, b);*/

        // logic 2 : using + and - operator , without using temp variable
        /*a = a + b; //a = 10+20 = 30
        b = a - b; // b = 30 -20 = 10
        a = a - b; // a = 30 -10 = 20*/

        //log.info("After Swapping a is:{}\n b is:{}", a, b);

        // logic 3 : using * and / operator , without using temp variable

        /*a = a * b; //a = 10*20 = 200
        b = a / b; // b = 200/10 = 20
        a = a / b; // a = 200/20 = 10

        log.info("After Swapping a is:{}\n b is:{}", a, b);*/

        //logic 4 : using ^ operator

       /* a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        log.info("After Swapping a is:{}\n b is:{}", a, b);*/

        // 5. Logic 5 : Single Statement

        b = a + b - (a = b);
        log.info("After Swapping a is:{}\n b is:{}", a, b);
    }
}
