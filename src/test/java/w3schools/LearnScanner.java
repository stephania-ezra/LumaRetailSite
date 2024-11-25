package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LearnScanner {
    public static Logger log = LogManager.getLogger(LearnScanner.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        log.info("Enter Name , Age and salary");

       String name = sc.nextLine();
       Integer age = sc.nextInt();
       double salary = sc.nextDouble();

        log.info("Enter Name: {}", name);
        log.info("Enter age: {}", age);
        log.info("Enter Salary: {}", salary);
    }
}
