package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumArrayElements {
    public static Logger log = LogManager.getLogger(SumArrayElements.class);

    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 15, 14};
        //log.info(arr.length); // 5
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // sum = 0 + 10 = 10
            // sum = 10 + 12 =22
            // sum = 22 + 13 = 35
            // sum = 35 + 15 = 50
            // sum = 50 + 14 = 64
        }
        log.info("Sum is:{}", sum);
    }
}
