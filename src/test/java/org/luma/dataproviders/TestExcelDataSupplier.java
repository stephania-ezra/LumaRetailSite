package org.luma.dataproviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestExcelDataSupplier {

    private static final String COMMA_DELIMITER = ",";
    public final Logger log = LogManager.getLogger(TestExcelDataSupplier.class);

    //data provider
    @DataProvider
    String[][] getLoginDetails() throws IOException {
        return Files
                .readAllLines(Paths.get("src", "test", "resources", "loginDetails.csv"))
                .stream()
                .map(line -> line.split(COMMA_DELIMITER))
                .filter(strings -> !strings[0].equalsIgnoreCase("emailId"))
                .filter(strings -> !strings[1].equalsIgnoreCase("password"))
                .toArray(String[][]::new);
    }

    @Test
    void dumpGetLoginDetails() throws IOException {
        String[][] array = getLoginDetails();
        for (Object item : array) {
            log.info("item {}", item);
        }
    }

    @Test
    void readNewCsv() {
        try {
            String[][] array = getLoginDetails();

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < 2; j++) {
                    log.info("array{}{} is {}", i, j, array[i][j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
