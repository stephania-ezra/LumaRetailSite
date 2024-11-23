package w3schools;

import interview.program.ReplaceStringCharacter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LearningMethods {
    public static Logger log = LogManager.getLogger(ReplaceStringCharacter.class);

    static void myMethod() {
        log.info("Learning Method Execution");
    }

    public static void main(String[] args) {
        //calling the myMethod()
        //calling the myMethod() multiple times
        
        myMethod();
        myMethod();
        myMethod();
    }
}
