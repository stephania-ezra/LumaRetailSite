package w3schools;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopThroughEnum {
    public static Logger log = LogManager.getLogger(LoopThroughEnum.class);

    enum Gender{
        BOY,
        GIRL,
        TRANSGENDER
    }
    public static void main(String[] args) {
        for (Gender g :Gender.values() ){
            log.info(g);
        }
    }
}
