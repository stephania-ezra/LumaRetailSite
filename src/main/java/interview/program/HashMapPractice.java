package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class HashMapPractice {
    public static Logger log = LogManager.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        HashMap<String, String> employee = new HashMap<String, String>();
        employee.put("Kumar", "Chennai");
        employee.put("Sankar", "Kovai");
        employee.put("Santhosh", "Chennai");
        employee.put("Kavitha", "Madurai");
        employee.put("Kavya", "Trichy");

        //log.info(employee.get("Kumar")); //Chennai
        //log.info(employee.values());

        //log.info(employee.values().equals("Chennai"));
        //log.info(employee.get("Chennai"));

        // log.info(employee.values().contains("Chennai"));

        //log.info(employee.containsValue("Chennai"));
        for (String key : employee.keySet()) {
            if (employee.get(key).equalsIgnoreCase("chennai")) {
                log.info("Name: {} City: {}", key, employee.get(key));
          }
        }
    }
}
/**
 *
 * if (employee.containsValue("Chennai")) {
 *                 log.info("Name: {} City: {}", key, employee.get(key));
 *             }
 */