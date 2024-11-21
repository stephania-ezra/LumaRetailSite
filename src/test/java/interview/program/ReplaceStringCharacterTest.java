package interview.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReplaceStringCharacterTest {

    private final Logger log = LogManager.getLogger(ReplaceStringCharacterTest.class);

    @Test
    void test_replace_string_first_last() {
        ReplaceStringCharacter rsc = new ReplaceStringCharacter();

        String data1 = "Ethan";
        String data2 = "Ezra";
        String data3 = "Stephania";

        assertEquals(rsc.replaceFirstandLast(data1), "nthaE");
        assertEquals(rsc.replaceFirstandLast(data2), "azrE");
        assertEquals(rsc.replaceFirstandLast(data3), "Stephania");
    }
}
