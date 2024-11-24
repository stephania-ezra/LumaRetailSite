package w3schools.polymorphism;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PolyMorphism {
    public static Logger log = LogManager.getLogger(PolyMorphism.class);

    public static void main(String[] args) {
        Animals a = new Animals();
        Animals f = new Fish();
        Animals d = new Dog();
        Animals c = new Cow();
        Animals b = new Bird();

        a.sound();
        f.sound();
        d.sound();
        c.sound();
        b.sound();
    }
}
