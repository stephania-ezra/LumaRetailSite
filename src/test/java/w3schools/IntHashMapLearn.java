package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class IntHashMapLearn {
    public static Logger log = LogManager.getLogger(IntHashMapLearn.class);

    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        people.put("Collins", 35);
        people.put("Ethan", 8);
        people.put("Ezra", 39);
        people.put("Phil", 63);

        log.info(people.get("Collins"));

        log.info("Size of people HashMap is:{}", people.size());
        log.info(people.remove("Phil"));

        log.info("Displaying People HashMap KeySet:{}", people.keySet());
        log.info("Displaying People HashMap Values:{}", people.values());

        for (String i : people.keySet()) {
            log.info("Name: {} Age: {}", i, people.get(i));
        }
    }
}
