package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FourDigits {
    public static Logger log = LogManager.getLogger(FibanocciSeries.class);

    public static void main(String[] args) {
        int[] arr = new int[]{123, 1234, 4567, 12, 8907};

        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);// converting integer to String
            if (s.length() > 3) {
                log.info("Four digit number is{}", arr[i]);
            }
        }
    }
}
