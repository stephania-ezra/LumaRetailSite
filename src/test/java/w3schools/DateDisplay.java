package w3schools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateDisplay {
    public static Logger log = LogManager.getLogger(DateDisplay.class);

    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        log.info("Before Formatting:{}", ldt);
       DateTimeFormatter dtf =DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");

        String formattedDate = dtf.format(ldt);
        log.info("After Formatting:{}", formattedDate);
    }
}
