package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class LearningHashSet {
    public static Logger log = LogManager.getLogger(LearningHashSet.class);

    public static void main(String[] args) {

        HashSet<String> shapes = new HashSet<String>();

        shapes.add("Oval");
        shapes.add("Circle");
        shapes.add("Rectangle");
        shapes.add("Triangle");
        shapes.add("Triangle"); // doesn't allow duplication

        //log.info(shapes);

        //log.info("HashSet Contains: {}", shapes.contains("Circle"));

        shapes.remove("Oval");
        shapes.size();
        // log.info(shapes);
        //log.info("Size is: {}", shapes.size());

        for (String shape : shapes) {
            log.info(shape);
        }
    }
}
