package let.code.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.LumaLoginTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LearningArray {

    private final Logger log = LogManager.getLogger(LumaLoginTest.class);

    @Test
    public void learning() {

        String[] friendsArray = {"Divya", "Raji", "Jones", "Godwin"};

        ArrayList<String> friendsArrayList1 =
                new ArrayList<>(Arrays.asList("Divya", "Raji", "Jones", "Godwin"));
        log.info(friendsArray[1]);
        log.info(friendsArrayList1.get(1));
    }
}
