package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 1. Constructors basic
 * 2. Parameters for Constructor -> passing one parameter
 * 3. passing more than one parameter for constructor
 */

/*public class ConstructorsLearning {
    public static Logger log = LogManager.getLogger(ConstructorsLearning.class);
    int x;

    //create a constructor
    public ConstructorsLearning() {
        x = 10;
    }
    
    public static void main(String[] args) {
        ConstructorsLearning cl = new ConstructorsLearning();
        log.info(cl.x);
    }
}*/

//Parameters for Constructors
/*public class ConstructorsLearning {

    public static Logger log = LogManager.getLogger(ConstructorsLearning.class);
    int x;

    public ConstructorsLearning(int y) {
        x = y;
    }

    public static void main(String[] args) {
        ConstructorsLearning cl = new ConstructorsLearning(30);
        log.info(cl.x);
    }
}*/
// passing more than one parameter in constructor
public class ConstructorsLearning {

    public static Logger log = LogManager.getLogger(ConstructorsLearning.class);
    int carModelYear;
    String carModelName;

    public ConstructorsLearning(int year, String name) {
        carModelYear = year;
        carModelName = name;
    }

    public static void main(String[] args) {
        ConstructorsLearning cl = new ConstructorsLearning(1989, "Ferrari");
        log.info("Car Model Year is:{}\n Car Model Name:{}", cl.carModelYear, cl.carModelName);
    }
}


