package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorLearn {
    public static Logger log = LogManager.getLogger(IteratorLearn.class);

    public static void main(String[] args) {
        ArrayList<String> birds = new ArrayList<String>();

        birds.add("Pigeon");
        birds.add("Crow");
        birds.add("Parrot");
        birds.add("Cuckoo");
        birds.add("KingFisher");

        Iterator<String> it = birds.iterator();

        //log.info(it.next()); // prints first item
        //log.info(birds);
        //log.info(it.hasNext()); // prints boolean value

        while(it.hasNext()){
            log.info(it.next());
        }
    }
}
