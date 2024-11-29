package schools.howto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AddNumUserInput {
    public static Logger log = LogManager.getLogger(AddNumUserInput.class);

    public static void main(String[] args) {
        int x, y, sum;
        Scanner sc = new Scanner(System.in);
        log.info("Enter First number");
        x = sc.nextInt();

        log.info("Enter Second number");
        y = sc.nextInt();

        sum = x + y;
        log.info("Sum of First and Second number is{}", sum);
    }
}
