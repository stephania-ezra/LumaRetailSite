package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class LearnHashMap {
    public static Logger log = LogManager.getLogger(LearnHashMap.class);

    public static void main(String[] args) {
        //capitalCities HashMap
// String data type
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        //adding keys and values(Country, City)
        capitalCities.put("India", "Chennai");
        capitalCities.put("Tokyo", "Japan");
        capitalCities.put("Washington DC", "USA");

        //log.info(capitalCities.get("India"));
        //capitalCities.remove("India");
        //log.info("Size of HashMap is:{}", capitalCities.size());

        //log.info(capitalCities);

        //for-each loop
        //keys -> KeySet()
        //value -> values()

        //log.info(capitalCities.keySet());

        //Printing KeySet
        for (String s : capitalCities.keySet()) {
            log.info(s);
        }

        //Printing values
        for (String i : capitalCities.values()) {
            log.info(i);
        }

        for (String i : capitalCities.keySet()) {
            log.info("Key:{} Value:{}", i, capitalCities.get(i));
        }
    }
}
