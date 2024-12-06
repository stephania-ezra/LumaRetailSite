package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * sorting Values in Hashmap
 */
public class HashmapSort {

    public static Logger log = LogManager.getLogger(HashmapSort.class);

    public static void main(String[] args) {

        HashMap<Integer,String> emp =  new HashMap<Integer,String>();

        emp.put(101,"Balu");
        emp.put(201,"George");
        emp.put(301,"David");
        emp.put(401,"Xavier");
        emp.put(501,"Harry");

        log.info("Original Map");

        for (Integer key : emp.keySet()){
            log.info("Key {} value {}", key, emp.get(key));
        }

        Set<Map.Entry<Integer,String>> entrySet = emp.entrySet();
        List<Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer,String>>(entrySet);

        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
               // return o1.getKey().compareTo(o2.getKey());// comparing keys
                return o1.getValue().compareTo(o2.getValue()); // compare values
                // either u can compare keys or u can compare values
            }
        });

        log.info("Map Sorted based on Values");
//printing the list

        for (Map.Entry<Integer,String> l : list){
            log.info(l.getKey() +"\t" + l.getValue());
        }
    }
}
