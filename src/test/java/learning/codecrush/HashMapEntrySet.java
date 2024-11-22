package learning.codecrush;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

    public class HashMapEntrySet {
        public static Logger log = LogManager.getLogger(learning.codecrush.HashMapEntrySet.class);

        public static void main(String[] args) {

            //Creating a Fruits HashMap
            HashMap<String, Integer> fruits = new HashMap<String, Integer>();
            fruits.put("Apple", 10);
            fruits.put("Orange", 20);
            fruits.put("Grapes", 30);
            fruits.put("Mango", 40);
            fruits.put("Banana", 50);
            fruits.put("Guava", 60);
            fruits.put("Papaya", 70);
            fruits.put("Strawberry", 80);
            fruits.put("Plums", 90);
            fruits.put("Cherry", 100);

            //log.info(fruits);
            log.info(fruits.keySet());

            // u cant do for each in HashMap
            //so get keyset and iterate over the keyset

            for (String fruit : fruits.keySet()) {
                log.info("Key:{}Value:{}", fruit, fruits.get(fruit));
            }

        }
    }


