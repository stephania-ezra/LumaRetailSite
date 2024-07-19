package org.luma;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelDataSupplier {

    private static final String COMMA_DELIMITER = ",";
    Iterator<List<String>> loginDetails = null;

    @DataProvider
    public Iterator<List<String>> getLoginDetails() throws IOException {
        return loginDetails;
    }

    @Test
    Iterator<List<String>> readLoginCSV() throws IOException {
        loginDetails = Files
                .readAllLines(Paths.get("src", "test", "resources", "loginDetails.csv"))
                .stream()
                .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                .filter(entry -> !entry.get(0).equalsIgnoreCase("Username"))
                //.filter(entry -> entry.get(2).equalsIgnoreCase("jacket"))
                .toList().iterator();
        return loginDetails;
    }

    @Test
    void dumpLoginCSV() throws IOException {
        Iterator<List<String>> listIterator = readLoginCSV();
        while (listIterator.hasNext()) {
            List<String> next = listIterator.next();
            System.out.println(next);

        }


    }
}
