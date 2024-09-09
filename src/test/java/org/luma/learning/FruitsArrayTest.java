package org.luma.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FruitsArrayTest {

    private final Logger log = LogManager.getLogger(FruitsArrayTest.class);

    @Test
    public void learning() {

        List<String> list = new ArrayList<String>();
        list.add("Cherry");
        list.add("DragonFruit");
        list.add("Plums");
        list.add("Cherry");
        list.add("Pomegranate");
        list.add("Chickoo");
        list.add("Banana");
        list.add("Dates");
        list.add("Apple");

        //log.info(list);
        //list.forEach(log::info);
        //before removing Cherry
        for (String eachFruit : list) {
            log.info(eachFruit);
        }
        int size = list.size();
        log.info("Size :{}", size);

        String eighthFruit = list.get(8);
        log.info("Eighth Fruit: {}", eighthFruit);

        list.remove("Cherry");
        boolean remove = list.remove("Coconut");
        log.info(remove);

        boolean contains = list.contains("Dates");
        log.info("List has fruit: {}", contains);

        String firstFruit = list.getFirst();
        log.info("Displaying first Fruit :{}", firstFruit);

        boolean empty = list.isEmpty();
        log.info("List is Empty", empty);
        list.clear();
        log.info(list.isEmpty());

        log.info("*****************************");
        //after removing Cherry
        for (String eachFruit : list) {
            log.info(eachFruit);
        }
        //size of the list
        int sizeAfterRemoval = list.size();
        log.info("Size :{}", sizeAfterRemoval);
    }
}
