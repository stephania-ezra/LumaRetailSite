package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.plugins.bmp.BMPImageWriteParam;


public class MyFirstClass {
    public static Logger log = LogManager.getLogger(MyFirstClass.class);

    public static void main(String[] args) {

        /*log.info("I am Stephania");
        log.info("Refreshing Java Concepts");
        log.info("It is awesome");

        log.info(3);
        log.info(3 + 3);
        log.info(5 * 5);

       String name = "Collins";
        log.info(name);

        int number = 10;
        log.info(number);

       int number = 12;
        number = 15; // reassigning the value
        log.info(number);

        final int num = 25;
        num = 30; //getting the error cannot assign a value to final variable
        log.info(num);*/

        /*int value = 10;
        char alphabet = 'A';
        String name = "Ethan";
        Boolean boo = true;
        float num = 2.0005f;*/

        //check with darli to print all these data types in a line . Is it possible?

        /*log.info(name);
        log.info(value);
        log.info(num);*/

        //condition statement - if , if else

        /*int x = 10;
        int y = 20;
        if (x > y) {
            log.info("x is greater than y");
        } else {
            log.info("y is greater than x");
        }

        //else -if

       /int z= 22;
        if (z<10) {
            log.info("abudhabi");
        }else if (z<20){
            log.info("Sharja");
        }else {
            log.info("Bahrain");
        }

        //real time example
        int doorCode = 1234;

        if (doorCode == 1234) {
            log.info("Correct code. The door is now open");
        } else {
            log.info("Wrong code , the door remains closed");
        }

        //switch cases
       int day =3;
        switch(day){
            case 1:
                log.info("Today is Monday");
                break;
            case 2:
                log.info("Today is Tuesday");
                break;
            case 3:
                log.info("Today is Wednesday");
                break;
            case 4:
                log.info("Today is Thursday");
                break;
            case 5:
                log.info("Today is Friday");
                break;
            case 6:
                log.info("Today is Saturday");
                break;
            case 7:
                log.info("Today is Sunday");
                break;
        }


        //default switch cases
        int day = 4;
        switch (day) {
            case 5:
                log.info("Today is Monday");
                break;
            case 6:
                log.info("Today is Tuesday");
                break;
            case 7:
                log.info("Today is Wednesday");
                break;
            default:
                log.info("Happy Weekend ");

        }

        //while statement
        int i = 0;
        while (i < 5){
            log.info(i);
            i++;
        }

        //Real time Example
        //i like this program :)
        int countDown = 3;
        while (countDown >0){
            log.info(countDown);
            countDown--;
        }
        log.info("Happy New Year");

        //if dice number is 6 , print yatzy

        int dice = 1;
        while (dice <= 6) {
            if (dice < 6) {
                log.info("no yatzy");
            } else {
                log.info("yatzy!");
            }
            dice = dice + 1;
        }

        //for loop
       for( int i = 0; i < 5 ; i++){
            log.info(i);
        }

        //loop inside loop
        //outer loop
        for ( int i =0 ; i <= 2 ; i ++){
            log.info("Outer loop:{}", i);

            //inner loop
            for ( int j = 0 ; j <= 3 ; j ++){
                log.info("Inner Loop:{}", j);
            }
        }
//execution will b like this :
        // 1. outer loop one time execute
        // outerloop: 0

        //inner loop: 0
        //inner loop: 1
        //inner loop: 2
        //inner loop: 3

        //outerloop : 1

        //inner loop: 0
        //inner loop: 1
        //inner loop: 2
        //inner loop: 3

        //outerloop : 2

        //inner loop: 0
        //inner loop: 1
        //inner loop: 2
        //inner loop: 3

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "," + j + " ");
            }
        }
        //1 ,1
        // 1, 2
        // 1 , 3
        //2,1
        // 2, 2
        // 2 , 3

        //For-Each Loop

        String[] cars = {"Breeza","Benz","Audi","Lambourgini","Porsche","Maruthi","i10","i20"};
        for ( String car : cars){
            log.info(car);
        }

        //real time example //printing upto 100 by tens

        for ( int i = 0; i <= 100 ; i += 10){
            log.info("Printing numbers by tens:{}", i);
        }

        // printing even values between 0 and 10

        for ( int i =0 ; i <= 10 ; i +=2 ){
            log.info("Even Numbers is:{}", i);
        }

        //printing 2 tables

        int number = 2 ;
        for ( int i =1 ; i <= 10 ; i++){
            log.info(number + "*" + i + "=" + (number * i));
        }

        //use of break in for loop
        // print from 0  to 3
        for ( int i = 0 ; i < 10 ; i++){
            if (i == 4) {
                break;
            }
            log.info(i);
        }


        //continue skips one
        for ( int i = 0 ; i < 10 ; i++){
            if (i == 4) {
                continue;
            }
            log.info(i);
        }


        //Arrays

        int[] numbers = {100,200,300,400,500,600,700,800,900,1000};
        log.info(numbers[5]); // output 600

        //change the array element
       int[] num = {100,200,300,400,500,600,700,800,900,1000};
        num[5] = 650;
        log.info(num[5]); // output is 650*/

        // length of an array
      /* String[] pens = {"Reynolds","Ball pen","Gel Pen","Ink Pen","Hero Pen","Rorito Pen"};
        log.info(pens[0]);
        log.info(pens.length);

        String[] penName = {"Reynolds","Ball pen","Gel Pen","Ink Pen","Hero Pen","Rorito Pen"};
        for ( int i = 0 ; i < penName.length ; i ++){
            log.info(penName[i]);
        }

        // for - Each
        String[] penName = {"Reynolds","Ball pen","Gel Pen","Ink Pen","Hero Pen","Rorito Pen"};
        for (String pen : penName){
            log.info(pen);
        }

       String[] cars = {"Volvo", "BMW", "Ford"};
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        /*output
        volvo
        "BMW"
        ford*/
    }
}