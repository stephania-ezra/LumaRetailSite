package w3schools.innerclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class OuterClass {
    public static Logger log = LogManager.getLogger(OuterClass.class);
    int x = 10;

    static class InnerClass {
        int y = 20;
    }
}
