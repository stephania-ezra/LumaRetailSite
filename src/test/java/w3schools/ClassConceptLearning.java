package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassConceptLearning {
    public static Logger log = LogManager.getLogger(ClassConceptLearning.class);

    int x = 5;
    int y = 10;
    String s = "Welcome";
    char ch = 'v';
    double d = 10.3;
    Boolean b = true;

    public static void main(String[] args) {
        ClassConceptLearning ccl = new ClassConceptLearning();
        log.info(ccl.x);
        log.info(ccl.y);
        log.info(ccl.s);
        log.info(ccl.ch);
        log.info(ccl.d);
        log.info(ccl.b);
    }
}
