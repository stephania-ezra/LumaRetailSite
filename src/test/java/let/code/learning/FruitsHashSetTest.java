package let.code.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

public class FruitsHashSetTest {

    private final Logger log = LogManager.getLogger(FruitsHashSetTest.class);

    @Ignore
    @Test
    public void learningHashSet() {

        // HashSet
        //removes duplicates and print in random order
        Set<String> set = new HashSet<>();
        set.add("Cherry");
        set.add("DragonFruit");
        set.add("Plums");
        set.add("Cherry");
        set.add("Pomegranate");
        set.add("Chickoo");
        set.add("Banana");
        set.add("Dates");
        set.add("Apple");

        for (String eachFruit : set) {
            log.info(eachFruit);
        }
    }

    @Ignore
    @Test
    public void learningTreeSet() {
        //TreeSet
        //removes duplicates and sorts in ascending order
        Set<String> set = new TreeSet<>();
        set.add("Cherry");
        set.add("DragonFruit");
        set.add("Plums");
        set.add("Cherry");
        set.add("Pomegranate");
        set.add("Chickoo");
        set.add("Banana");
        set.add("Dates");
        set.add("Apple");

        for (String eachFruit : set) {
            log.info(eachFruit);
        }
    }

    @Ignore
    @Test
    public void learningLinkedHashSet() {
        //LinkedHashSet
        //Print data in exact same way as given

        Set<String> set = new LinkedHashSet<>();
        set.add("Cherry");
        set.add("DragonFruit");
        set.add("Plums");
        set.add("Cherry");
        set.add("Pomegranate");
        set.add("Chickoo");
        set.add("Banana");
        set.add("Dates");
        set.add("Apple");

        boolean contains = set.contains("Dates");
        log.info(contains);
        log.info(set.isEmpty());
        set.clear();


        for (String eachFruit : set) {
            log.info(eachFruit);
        }
        log.info(set.size());
        /* there is no get property for set
        we can retrieve the value by creating a List and we can retrieve from it
         */
    }

    @Test
    public void LinkedHashSetTest() {
        //LinkedHashSet
        //Print data in exact same way as given

          /* there is no get property for set
        we can retrieve the value by creating a List and we can retrieve from it
         */
        Set<String> set = new LinkedHashSet<>();
        set.add("Cherry");
        set.add("DragonFruit");
        set.add("Plums");
        set.add("Cherry");
        set.add("Pomegranate");
        set.add("Chickoo");
        set.add("Banana");
        set.add("Dates");
        set.add("Apple");

        List<String> myList = new ArrayList<String>(set);
        for (String eachFruit : myList) {
            log.info(eachFruit);
        }
        log.info("********************************");
        String fruitFirst = myList.getFirst();
        log.info("Printing First Fruit: {}", fruitFirst);
    }
}
