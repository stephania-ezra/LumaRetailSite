package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YearConstructor {
    public static Logger log = LogManager.getLogger(YearConstructor.class);
    int yearNumber;

    public YearConstructor(int year) {
        yearNumber = year;
    }

    public static void main(String[] args) {
        YearConstructor yc = new YearConstructor(1992);
        if (yc.yearNumber % 4 == 0) {
            log.info("it is a leap year");
        } else {
            log.info("not a leap year");
        }
    }
}
