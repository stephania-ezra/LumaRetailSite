package learning.codecrush;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class AlphabetOccurence {

    public static Logger log = LogManager.getLogger(AlphabetOccurence.class);

    public static void main(String[] args) {

        String str = "aabbccdd";

        HashMap<Character, Integer> store = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (store.containsKey(ch)) {
                int count = store.get(ch);
                count++;
                store.replace(ch, count);
            } else {
                store.put(ch, 1);
            }
        }
        for (Character key : store.keySet()) {
            //log.info("{}{}", key, store.get(key));
            log.info("Key:{}Value:{}", key, store.get(key));
        }
    }
}
