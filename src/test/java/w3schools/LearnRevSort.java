package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class LearnRevSort {
    public static Logger log = LogManager.getLogger(LearnRevSort.class);

    public static void main(String[] args) {
        ArrayList<String> wildAnimals = new ArrayList<String>();
        wildAnimals.add("Tiger");
        wildAnimals.add("Lion");
        wildAnimals.add("Cheetah");
        wildAnimals.add("Fox");
        wildAnimals.add("Giraffe");

        //Collections.sort(wildAnimals); // sort wildAnimals
        Collections.sort(wildAnimals, Collections.reverseOrder()); // sorting in reverse order

        for (String wildAnimal : wildAnimals) {
            log.info(wildAnimal);
        }
    }
}
