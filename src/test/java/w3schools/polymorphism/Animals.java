package w3schools.polymorphism;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Animals {
    public static Logger log = LogManager.getLogger(Animals.class);

    public void sound() {
        log.info("Animal makes sound");
    }
}

class Dog extends Animals {
    public void sound() {
        log.info("Dog makes oofff");
    }
}

class Fish extends Animals {
    public void sound() {
        log.info("fish makes fff");
    }
}

class Cow extends Animals {
    public void sound() {
        log.info("cow makes moooo");
    }
}

class Bird extends Animals {
    public void sound() {
        log.info("Bird makes tweet");
    }
}
