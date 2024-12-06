package learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.K;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDec5 {
    public static Logger log = LogManager.getLogger(HashMapDec5.class);

    public static void main(String[] args) {

        HashMap<String, Integer> months = new HashMap<String, Integer>();

        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);

        //log.info(months.keySet());
        //log.info(months.values());

        //iterate over the hashmap and get the lowest value--incomplete
       /* for (int val :months.values()){
            log.info(val);
        }*/

        //Iteration methods - keySet()
        //*******************************
        // 1. for each loop

        /*Set<String> keys = months.keySet(); // it will return a set of keys
        for (String key : keys){
            log.info(key);
        }*/

        //2. by using Iterator method

        /*Set<String> keys = months.keySet();
        Iterator<String> itr = keys.iterator(); // returns Iterator object of String
        while (itr.hasNext()) {
            log.info(itr.next());
        }*/

        //3. java 8 for each
        /*Set<String> keys = months.keySet();
        keys.forEach(k -> System.out.println(k));*/

        // iteration methods - months.values()
        // months.values()
        // 1. for each loop
       /* for (Integer month : months.values()){
            log.info(month);
        }*/

        //2. by using Iterator method
        //months.values().iterator();

        /*Iterator<Integer> itr = months.values().iterator();
        while (itr.hasNext()) {
            log.info(itr.next());
        }*/

        //3. using java 8
        // months.values().forEach(v->System.out.println(v));

        // iteration methods - entrySet()

        //1.for each method
        /*Set<Map.Entry<String, Integer>> entries = months.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            log.info("key ["+entry.getKey()+"] value ["+entry.getValue()+"]");
        }*/

        //2. Iterator
       /* Set<Map.Entry<String, Integer>> entries = months.entrySet();
        Iterator<Map.Entry<String, Integer>> itr = entries.iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            log.info("key ["+entry.getKey()+"] value ["+entry.getValue()+"]");
        }*/

        //3. java 8
        Set<Map.Entry<String, Integer>> entries = months.entrySet();
        entries.forEach(entry -> System.out.println("key ["+entry.getKey()+"] value ["+entry.getValue()+"]") );
    }
}
