package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class LoopThroughArrayList {
    public static Logger log = LogManager.getLogger(LoopThroughArrayList.class);

    public static void main(String[] args) {

       /* ArrayList<String> soaps =  new ArrayList<String>();
        soaps.add("Mysore Sandal");
        soaps.add("Cinthol");
        soaps.add("Lux");
        soaps.add("Femina");
        soaps.add("Hamam");

        for (String soap: soaps){
            log.info("List of soap:{}", soap);
        }*/

        HashMap<String,Integer> soaps =  new HashMap<String,Integer>();
        soaps.put("Hamam",2);
        soaps.put("Cinthol",1);
        soaps.put("lifeboy",3);
        soaps.put("Femina",10);
        soaps.put("Mysore Sandal",5);
        //log.info(soaps.keySet());
        //log.info(soaps.values());

        /*for(String soap : soaps.keySet()){
            log.info(soap);
        }*/

        /*for (Integer soap : soaps.values()){
            log.info(soap);
        }*/

        for( String soap :soaps.keySet()){
            log.info("key: {} value: {}", soap, soaps.values());
        }
    }
}
