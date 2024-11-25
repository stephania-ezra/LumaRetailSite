package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

/**
 * 1. add items to the linked list
 * 2.
 */
public class learningLinkedList {
    public static Logger log = LogManager.getLogger(learningLinkedList.class);

    public static void main(String[] args) {
        LinkedList<String> flowers = new LinkedList<String>();
        flowers.add("Jasmine");
        flowers.add("Rose");
        flowers.add("Sunflower");
        flowers.add("Lily");

        //flowers.addFirst("Tulips");
        //flowers.addLast("Daffodils");

        //flowers.removeLast();
        //flowers.removeFirst();

        log.info("First Flower is:{}", flowers.getFirst());
        log.info("Last Flower is:{}", flowers.getLast());
        //print the Linked list

        // for (String flower : flowers) {
        //   log.info(flower);
        //}
    }
}
