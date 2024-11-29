package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 1. already this program is done in MaximumAndMinimum program
 * 2. this is for practice
 */
public class SmallestElement {

    public static Logger log = LogManager.getLogger(SmallestElement.class);

    public static void main(String[] args) {
        int[] ages = {20, 22, 18, 35, 48, 26, 87, 70};
        int min = ages[0];
        // assume ages[0] is the smallest
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < min) {
                min = ages[i];
            }
        }
        log.info("Smallest Element is:{}", min);
    }
}
// workflow
//1. assume min = 20
//2. 22 < 20 =>false , again no change min is 20
//3. 18<20 => true , now min =18
//4. 35<20 => false , again no change min is 20
//5. 48< 20 => false ,again no change min is 20
//6.26<20 => false ,again no change min is 20
//7.87<20 => false ,again no change min is 20
//8.70<20 => false , again no change min is 20

// so the smallest Element is 20