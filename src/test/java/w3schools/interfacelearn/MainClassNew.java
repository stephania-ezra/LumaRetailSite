package w3schools.interfacelearn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import w3schools.ClassConceptLearning;

/**
 * Interface concept
 * using the methods , variables used in more than one Interface
 */
interface Fruits{
    int mark = 10;
    void eat();
    void peel();
    void makeJuice();
    void cut();
    void throwWaste();
}

interface Vegetables{
    int amount = 10;
    void cook();
}

interface Snacks{
    int amount = 10;
    void junkfood();
}

//subclass

class Apple implements Fruits{

    public static Logger log = LogManager.getLogger(Apple.class);
    @Override
    public void eat() {
        log.info("Eating Apple");
    }

    @Override
    public void peel() {
        log.info("Peeling Apple");
    }

    @Override
    public void makeJuice() {
        log.info("Making Apple juice");
    }

    @Override
    public void cut() {
        log.info("Cutting Apple");
    }

    @Override
    public void throwWaste() {
        log.info("Throwing Apple Waste");
    }
}

class Orange implements Fruits,Vegetables,Snacks {
    public static Logger log = LogManager.getLogger(Orange.class);
    @Override
    public void eat() {
        log.info("Eating Orange");
    }

    @Override
    public void peel() {
        log.info("Peeling Orange");
    }

    @Override
    public void makeJuice() {
        log.info("Making Orange Juice");
    }

    @Override
    public void cut() {
        log.info("Cutting Orange");
    }

    @Override
    public void throwWaste() {
        log.info("Throwing Orange Waste");
    }

    @Override
    public void cook() {
        log.info("Cooking Vegetables");
    }

    @Override
    public void junkfood() {
        log.info("Eating junk food is not good for health");
    }
}
public class MainClassNew {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(ClassConceptLearning.class);

        /*Apple a = new Apple();
        a.eat();
        a.makeJuice();
        a.peel();
        a.throwWaste();
        a.cut();*/

        Orange O = new Orange();
        O.cut();
        O.eat();
        O.peel();
        O.throwWaste();
        O.makeJuice();
        O.cook();
        O.junkfood();

        log.info(Fruits.mark);
    }
}
