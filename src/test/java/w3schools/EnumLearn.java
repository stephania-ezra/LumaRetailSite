package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnumLearn {

    public static Logger log = LogManager.getLogger(EnumLearn.class);
    enum Months{
        JAN,
        FEB,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOIBER,
        NOVEMBER,
        DECEMBER
}

    public static void main(String[] args) {
       // Level var = Level.HIGH;
        for (Months month :Months.values() ){
            log.info(month);
        }
        //Level.values() -> returns an array of all enum constants
        //switch case
        /*switch(var){
            case LOW:
                log.info("Low Level is printed");
                break;
            case MEDIUM:
                log.info("Medium Level is printed");
                break;
            case HIGH:
                log.info("High Level is printed");
                break;
        }*/
    }
}
