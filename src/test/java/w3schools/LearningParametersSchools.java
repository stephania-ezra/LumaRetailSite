package w3schools;

public class LearningParametersSchools {

//multiple parameters
/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static void myMethod(String firstName, String middleName) {
        log.info("{} {} Lovely", firstName, middleName);
    }

    public static void main(String[] args) {
        myMethod("Reeta", "Ruby");
        myMethod("Rosy", "Stella");
        myMethod("Collins", "Stephania");
    }
}*/


/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static void myMethod(String firstName, int age) {
        log.info("{} is {}", firstName, age);
    }

    public static void main(String[] args) {
        myMethod("Ethan", 8);
        myMethod("Collins", 35);
        myMethod("Ezra", 39);
    }
}*/

/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static void checkAge(int Age) {
        if (Age < 18) {
            log.info("Access denied -u r not old enough");
        } else {
            log.info("Access Granted - u r old enough");
        }
    }

    public static void main(String[] args) {
        checkAge(15);
    }
}*/

//Return values
// with one parameter
/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static int myMethod(int x) {
        return 5 + x;
    }

    public static void main(String[] args) {
        log.info(myMethod(3)); // output: 5+3 = 8
    }
}*/

//Return values
// with two parameter

/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static int myMethod(int x, int y) {
        return 5 + x + y;
    }

    public static void main(String[] args) {
        log.info(myMethod(3, 5)); // output: 5+3+5 = 13
    }
}*/

/*public class LearningParametersSchools {
    public static Logger log = LogManager.getLogger(LearningParameters.class);

    static int myMethod(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int z = myMethod(5, 3);
        log.info("Value of Z is:{}", z);
    }
}*/
}
