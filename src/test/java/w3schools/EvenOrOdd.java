package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class EvenOrOdd {
    public static Logger log = LogManager.getLogger(EvenOrOdd.class);

    public static void main(String[] args) {
        //getting input from the user
        /*Scanner input = new Scanner(System.in);
        log.info("Enter a number");

        int n = input.nextInt();
        if (n % 2 ==0){
            log.info("The given number {} is Even number", n);
        }else{
            log.info("The given number {} is Odd number", n);
        }*/

        // loop through a list
        /*ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(11);
        numbers.add(13);
        numbers.add(50);
        numbers.add(121);
         for (int number :numbers){
             if (number % 2 == 0){
                 log.info("The given number {} is Even number", number);
             }else{
                 log.info("The given number {} is Odd number", number);
             }
         }*/

        //loop through from 1 to 10

        /*Scanner input = new Scanner(System.in);
        log.info("Enter the max values for even or odd calculation");

        int max = input.nextInt();
        for ( int i =1 ; i <= max ; i++){
            if (i % 2 == 0){
                log.info("The given number {} is Even number", i);
            }else{
                log.info("The given number {} is Odd number", i);
            }
        }*/
    }
}
