package interview.program;

import com.google.common.collect.Multiset;
import org.apache.commons.collections4.MultiSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateString {

    public static Logger log = LogManager.getLogger(MaximumAndMinimum.class);

    //method 1 : using 2 for loops -> more resource consuming and time taking
    /*public static void main(String[] args) {
        String[] names = {"Ethan", "collins", "Philo", "Ezra","collins","Philo"};
        int length = names.length;

        // 1.compare each element
        for( int i =0 ;i < names.length ; i++){
            // to get the second element we use i=1
            for (int j= i+1 ; j<names.length ; j++){
                if(names[i].equals(names[j])){
                    log.info("duplicate String is:{}", names[i]);
                }
            }
        }*/

    //method 2 : using HashSet
    /*public static void main(String[] args) {
        String[] names = {"Ethan", "collins", "Philo", "Ezra", "collins", "Philo"};
        Set<String> store = new HashSet<String>();
        for (String name : names) {
            //if(store.add(name) == false){
            // the above line is simplified below
            if (!store.add(name)) {
                log.info("duplicate string is:{}", name);
            }
        }
    }*/

    //method 3 : using HashMap
    public static void main(String[] args) {
        String[] names = {"Ethan", "collins", "Philo", "Ezra", "collins", "Philo"};
        Map<String, Integer> storeMap = new HashMap<String, Integer>();
        for (String name : names) {
            Integer count = storeMap.get(name);
            if (count == null) {
                storeMap.put(name, 1);
            } else {
                storeMap.put(name, ++count);
            }
        }
        //log.info(storeMap.entrySet());

        for(Map.Entry<String,Integer> entry :storeMap.entrySet()){
            //log.info("Key:{}Value:{}", entry.getKey(), entry.getValue());
            if(entry.getValue()>1){
                log.info("Duplicate word is:{}", entry.getKey());
            }
        }
    }
}

//incomplete
//get value from the map
        /*Set<Map.Entry<String, Integer>> entrySet = storeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (Map.Entry.comparingByKey() > 1) {
                log.info("Duplicate string is:{}", entry.getKey());
            }
        }*/