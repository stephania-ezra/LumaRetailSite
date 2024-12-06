package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IntHashMapLearn {
    public static Logger log = LogManager.getLogger(IntHashMapLearn.class);

    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        people.put("Collins", 35);
        people.put("Ethan", 8);
        people.put("Ezra", 39);
        people.put("Phil", 63);

        //log.info(people.get("Collins"));

       /* log.info("Size of people HashMap is:{}", people.size());
        log.info(people.remove("Phil"));
        log.info("Displaying People HashMap KeySet:{}", people.keySet());
        log.info("Displaying People HashMap Values:{}", people.values());*/

        /*for (String i : people.keySet()) {
            log.info("Name: {} Age: {}", i, people.get(i));
        }*/

        //Printing keys by using Set
        /*Set<String> keys = people.keySet();
        for ( String key: keys){
            log.info(key);
        }*/

        // printing keys by using Iterator
        /*Set<String> keys = people.keySet();
        Iterator<String> itr= keys.iterator();
        while(itr.hasNext()){
            log.info(itr.next());
        }*/

        // printing key value pair use entrySet
        /*Set<Map.Entry<String, Integer>> entries = people.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            log.info("Key [" + entry.getKey() + "] Value [" + entry.getValue() + "]");
        }*/

        // using iterator
        Set<Map.Entry<String, Integer>> entries = people.entrySet();
        Iterator<Map.Entry<String, Integer>> itr = entries.iterator();
        while(itr.hasNext()){

            Map.Entry<String, Integer> entry = itr.next();
            log.info("Key ["+entry.getKey()+ "] Value ["+ entry.getValue()+"]");
        }
    }
}
