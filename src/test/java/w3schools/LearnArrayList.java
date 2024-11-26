package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1. Adding items to the cars list
 * 2.add car "Porsche" at the first position
 * 3.add car"Toyota" at the third position
 * 4.remove a car item from the list
 * 5.size of an array
 * 6.loop through an Array List
 * 7. creating an Integer array List and add integers to the array
 * 8.sort the array
 */

public class LearnArrayList {
    public static Logger log = LogManager.getLogger(LearnArrayList.class);

    public static void main(String[] args) {

        /*ArrayList<String> cars = new ArrayList<String>();
        //1. add items to the Cars list
        cars.add("Volvo");
        cars.add("Benz");
        cars.add("Brezza");
        cars.add("Honda");
        cars.add("Land Rover");

        //2. add car "Porsche" at the first position
        cars.addFirst("Porsche"); //[Porsche, Volvo, Benz, Brezza, Honda, Land Rover]

        //3. add car"Toyota" at the third position
        cars.add(2,"Toyota"); //[Porsche, Volvo, Toyota, Benz, Brezza, Honda, Land Rover]

        //4. remove a car item from the list
        //benz is in 3rd position , so give 3 and remove benz

        cars.remove(3);//[Porsche, Volvo, Toyota, Brezza, Honda, Land Rover]

        //5.size of an array
        cars.size();
        log.info("Cars list is:{}", cars.size()); */

        //6.loop through an Array List
       ArrayList<String> cars = new ArrayList<String>();

        cars.add("Volvo");
        cars.add("Benz");
        cars.add("Brezza");
        cars.add("Honda");
        cars.add("Land Rover");
        Collections.sort(cars);

        /*for (int i = 0; i < cars.size(); i++) {
            log.info(cars.get(i));
        }*/

            // for each loop
        for( String car : cars){
            log.info(car);
        }

        //7.creating an Integer array List and add integers to the array
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        Collections.sort(numbers);

        for( int num : numbers){
            log.info(num);
        }
    }
}


