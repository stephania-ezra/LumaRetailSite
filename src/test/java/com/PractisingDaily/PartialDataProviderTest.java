package com.PractisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartialDataProviderTest {
    public final Logger log = LogManager.getLogger(PartialDataProviderTest.class);

    @Test(dataProvider = "partialData")
    public void partialMain(String name) {
        log.info(name);
    }

    @DataProvider(indices = {0, 1, 4})
    public String[] partialData() {
        String[] name = new String[]{
                "Stephania",
                "Zephorah",
                "Collins",
                "Ethan",
                "Moses"
        };
        return name;
    }
}
