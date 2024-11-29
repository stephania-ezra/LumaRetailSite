package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayAverage {
    public static Logger log = LogManager.getLogger(ArrayAverage.class);

    public static void main(String[] args) {
        int[] age = {20, 22, 18, 35, 48, 26, 87, 70};
        int sum = 0;
        int avg, length, i;

        for (i = 0; i < age.length; i++) {  // length = age.length; // 8
            sum = sum + age[i];
        }
        avg = sum / age.length;
        log.info("Average is:{}", avg);
    }
}
