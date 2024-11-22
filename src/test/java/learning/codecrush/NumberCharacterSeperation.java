package learning.codecrush;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberCharacterSeperation {

    public static Logger log = LogManager.getLogger(NumberCharacterSeperation.class);

    public static void main(String[] args) {

        String str = "12345asdvf78sdf";
        log.info(str.replaceAll("[0-9]", "")); //output asdvfsdf

        // now considering only alphabets
        //log.info(str.replaceAll("[^0-9]", "")); // output 1234578
    }
}
