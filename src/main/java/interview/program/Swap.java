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
        a = a + b; //a = 10+20 = 30
        b = a - b; // b = 30 -20 = 10
        a = a - b; // a = 30 -10 = 20

        log.info("After Swapping a is:{}\n b is:{}", a, b);

    }
}
