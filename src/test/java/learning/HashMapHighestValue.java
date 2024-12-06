package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.max;

/**
 * getting Highest value in a hashmap :)
 * happy  that I learned this today
 */
public class HashMapHighestValue {
    public static Logger log = LogManager.getLogger(HashMapHighestValue.class);

    public static void main(String[] args) {
        HashMap<String,Integer> student = new HashMap<String,Integer>();
        student.put("English",76);
        student.put("Tamil",64);
        student.put("Maths",53);
        student.put("Science",86);
        student.put("social",41);

       int highestValue = Collections.max(student.values());


        Set<Map.Entry<String,Integer>> studentsName = student.entrySet();
        for (Map.Entry<String,Integer> studentName : studentsName){
            if (studentName.getValue() == highestValue){
                log.info("Subject:{} Highest Score:{}", studentName.getKey(), studentName.getValue());
            }
        }
    }
}
