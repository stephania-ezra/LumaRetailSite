package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDec6Cont {
    public static Logger log = LogManager.getLogger(HashMapDec6Cont.class);

    public static void main(String[] args) {
        HashMap<String,Integer> employeeIds = new HashMap<String,Integer>();
        employeeIds.put("Collins",1122); // add a key value
        employeeIds.put("Moses",123);
        employeeIds.put("Ethan",456);

        /*Set<Map.Entry<String,Integer>> entries = employeeIds.entrySet();
        for (Map.Entry<String,Integer> entry : entries){
            log.info("Name ["+entry.getKey()+"] Id["+entry.getValue()+"]");
        }
        log.info("---------------------------------------");

        //creating another hashmap
        HashMap<String, Integer> anotherMap = new HashMap<String, Integer>();
        anotherMap.put("Josy",22);
        anotherMap.put("Ruby",32);

        //Inserting key-value pairs of employeeIds map to anotherMap using putAll() method
        anotherMap.putAll(employeeIds);

        Set<Map.Entry<String,Integer>> entries1 = anotherMap.entrySet();
        for (Map.Entry<String,Integer> entry : entries1){
            log.info("Name ["+entry.getKey()+"] Id["+entry.getValue()+"]");
        }
        log.info("---------------------------------------");*/

        //Getting synchronized Map

        Map<String, Integer> syncMap = Collections.synchronizedMap(employeeIds);

        log.info(syncMap);

    }
}
