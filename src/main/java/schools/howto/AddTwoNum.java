package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddTwoNum {
    public static Logger log = LogManager.getLogger(AddTwoNum.class);

    public static void main(String[] args) {
        int x = 12;
        int y = 13;
        int sum = x + y;
        log.info("Sum of x:{} and y:{} = {}", x, y, sum);
    }
}
