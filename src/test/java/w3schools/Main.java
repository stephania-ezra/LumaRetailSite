package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static Logger log = LogManager.getLogger(Main.class);

    //static method
    static void myStaticMethod() { //this is a static method
        log.info("Static methods can be called without creating objects");
    }

    //main method
    public static void main(String[] args) {
        myStaticMethod();// calling static method
        //prints Static methods can be called without creating objects

        //myPublicMethod(); //java: non-static method myPublicMethod() cannot be
        // referenced from a static context
        Main myObj = new Main(); //creating an object
        myObj.myPublicMethod();// calling the public method

        //calling MainNew Class (ie) another class

        MainNew mn = new MainNew(); // creating a object and calling the other class
        mn.fullThrottle(); //call the fullThrottle() method
        mn.speed(40); //call the speed()
    }

    //public method
    public void myPublicMethod() { //this is a static method
        log.info("Public methods must be called by creating objects");
    }
}
