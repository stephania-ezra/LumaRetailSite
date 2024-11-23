package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainNew {
    public static Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MainNew mn = new MainNew();
        mn.fullThrottle();
        mn.speed(30);
    }

    //public method fullThrottle()
    public void fullThrottle() {
        log.info("The car is going as fast as it can");
    }

    // public method speed
    public void speed(int MaxSpeed) {
        log.info("Max Speed is:{}", MaxSpeed);
    }
}
