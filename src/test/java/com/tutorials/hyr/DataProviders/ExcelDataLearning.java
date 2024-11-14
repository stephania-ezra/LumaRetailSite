package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllLines;
import static java.util.Locale.filter;
import static org.apache.commons.collections4.IteratorUtils.toArray;

public class ExcelDataLearning {

    private static final String COMMA_DELIMITER = ",";
    public final Logger log = LogManager.getLogger(ExcelDataLearning.class);


    @Test
    void loginDetailsExcel() throws IOException {
        String [][] array = getLoginDetails();
        for(String[] data:array ){
            log.info("data:{}",data);
        }
    }

    @DataProvider
    String[][] getLoginDetails() throws IOException {
        return Files
                .readAllLines(Paths.get("src", "test", "resources", "loginDetailsLearning.csv"))
                .stream()
                .map(line -> line.split(COMMA_DELIMITER))
                .filter(strings -> !strings[0].equalsIgnoreCase("emailId"))
                .filter(strings -> !strings[1].equalsIgnoreCase("password"))
                .toArray(String[][]::new);
    }

}


