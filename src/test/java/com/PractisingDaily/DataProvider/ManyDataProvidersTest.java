package com.PractisingDaily.DataProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

public class ManyDataProvidersTest {
    public final Logger log = LogManager.getLogger("ManyDataProvidersTest.class");

    //Too Many  DataProvider
    //First DataProvider
    @DataProvider
    public Object[][] swagData1() {
        Object[][] data = new Object[7][2];

        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        data[1][0] = "secret_sauce";
        data[1][1] = "secret_sauce";

        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        data[4][0] = "performance_glitch_user";
        data[4][1] = "secret_sauce";

        data[5][0] = "visual_user";
        data[5][1] = "secret_sauce";

        data[6][0] = "standard_user";
        data[6][1] = "test123";

        return data;
    }

    //second DataProvider

    @DataProvider
    public Object[][] swagData2() {
        Object[][] data = new Object[7][2];

        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        data[1][0] = "secret_sauce";
        data[1][1] = "secret_sauce";

        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        data[4][0] = "performance_glitch_user";
        data[4][1] = "secret_sauce";

        data[5][0] = "visual_user";
        data[5][1] = "secret_sauce";

        data[6][0] = "standard_user";
        data[6][1] = "test123";

        return data;
    }

    //Third DataProvider

    @DataProvider
    public Object[][] swagData3() {
        Object[][] data = new Object[7][2];

        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        data[1][0] = "secret_sauce";
        data[1][1] = "secret_sauce";

        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        data[4][0] = "performance_glitch_user";
        data[4][1] = "secret_sauce";

        data[5][0] = "visual_user";
        data[5][1] = "secret_sauce";

        data[6][0] = "standard_user";
        data[6][1] = "test123";

        return data;
    }
}
