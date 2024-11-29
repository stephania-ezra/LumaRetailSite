package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StrToArray {
    public static Logger log = LogManager.getLogger(StrToArray.class);

    public static void main(String[] args) {
        String str = "Collins";
        char[] arr = str.toCharArray();
        // for loop
        /*for (int i = 0; i < arr.length; i++) {
            log.info(arr[i]);
        }*/

//for each
        for (char s : arr) {
            log.info(s);
        }
    }
}
