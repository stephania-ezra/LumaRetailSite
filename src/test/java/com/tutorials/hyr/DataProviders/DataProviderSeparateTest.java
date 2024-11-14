package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSeparateTest {

    public final Logger log = LogManager.getLogger("DataProviderSeparateTest.class");

    @Test(dataProvider = "dataProvider1")
    public void dataProviderPrint(String [] s){
        log.info("{}*****{}", s[0], s[1]);
    }

    @DataProvider
    public String[][] dataProvider1(){

        String[][] data = new String[][]{
                {"collins","Stephy"} ,
                {"Ethan","Papu"} ,
                {"Ezra","Darli"}
        };
        return data;
    }
}
