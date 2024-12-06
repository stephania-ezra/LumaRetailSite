package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hashmap to find the smallest value
 * happy that I learned this today :)
 */
public class HashMapSmallestValue {
    public static Logger log = LogManager.getLogger(HashMapHighestValue.class);

    public static void main(String[] args) {
        HashMap<String,Integer> student = new HashMap<String,Integer>();
        student.put("English",76);
        student.put("Tamil",64);
        student.put("Maths",53);
        student.put("Science",86);
        student.put("social",41);

        int smallestValue = Collections.min(student.values());

        Set<Map.Entry<String,Integer>> studentsName = student.entrySet();
        for (Map.Entry<String,Integer> studentName : studentsName){
            if (studentName.getValue() == smallestValue){
                log.info("Subject:{} Smallest Score:{}", studentName.getKey(), studentName.getValue());
            }
        }
    }
}
