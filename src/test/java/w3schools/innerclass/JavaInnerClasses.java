package w3schools.innerclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavaInnerClasses {
    public static Logger log = LogManager.getLogger(JavaInnerClasses.class);

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass myInner = new OuterClass.InnerClass();
        log.info(myInner.y + oc.x);
    }
}
