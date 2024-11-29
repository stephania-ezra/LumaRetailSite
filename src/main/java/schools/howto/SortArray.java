package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortArray {
    public static Logger log = LogManager.getLogger(SortArray.class);

    public static void main(String[] args) {
        String[] names = {"Collins", "Ethan", "Einstein", "Philo", "Ritchie", "Hema", "Ezra"};
        Arrays.sort(names);
        // for loop
        /*for (int i = 0; i < names.length; i++) {
            log.info(names[i]);
        }*/

        //for each loop
        for (String s : names) {
            log.info(s);
        }
    }
}
