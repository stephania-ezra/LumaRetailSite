package learning.john;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class HashMapBasic {

    public static Logger log = LogManager.getLogger(HashMapBasic.class);

    public static void main(String[] args) {

        HashMap<String,Integer> empIds = new HashMap<String,Integer>();

        empIds.put("Collins",1122); // add a key value
        empIds.put("Moses",123);
        empIds.put("Ethan",456);

        log.info(empIds);

        log.info(empIds.get("Moses"));
        log.info(empIds.containsKey("Einstein"));

        log.info(empIds.containsValue(12));
        log.info(empIds.containsValue(123));

        empIds.put("Collins",2211);
        log.info(empIds); //replace the existing value

        empIds.replace("Collins",9876);
        log.info(empIds);

        empIds.replace("Sheela",9876); //sheela doesnt exist
        log.info(empIds);

        empIds.putIfAbsent("Sheela",9876);
        log.info(empIds);

        empIds.remove("Collins");
        log.info(empIds);
    }

}
