package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionsLearning {
    public static Logger log = LogManager.getLogger(ExceptionsLearn.class);

    public static void checkAge(int age){
    if (age < 18) {
        throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }else{
        log.info("Access granted");
    }
}
    public static void main(String[] args) {
        checkAge(20);
    }
}
