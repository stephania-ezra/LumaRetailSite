package org.luma.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LumaDataProviders {

    private static final String COMMA_DELIMITER = ",";

    @DataProvider
    public Iterator<List<String>> jacketProducts() throws IOException {
        return readCsvJacket();
    }

    @DataProvider(parallel = true)
    public Iterator<List<String>> otherProducts() throws IOException {
        return readCsvOtherProducts();
    }

    Iterator<List<String>> readCsvJacket() throws IOException {
        return Files
                .readAllLines(Paths.get("src", "test", "resources", "products.csv"))
                .stream()
                .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                .filter(entry -> !entry.get(0).equalsIgnoreCase("name"))
                .filter(entry -> entry.get(2).equalsIgnoreCase("jacket"))
                .toList().iterator();
    }

    Iterator<List<String>> readCsvOtherProducts() throws IOException {
        return Files
                .readAllLines(Paths.get("src", "test", "resources", "products.csv"))
                .stream()
                .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                .filter(entry -> !entry.get(0).equalsIgnoreCase("name"))
                .filter(entry -> !entry.get(2).equalsIgnoreCase("jacket"))
                .toList().iterator();
    }

    @Test
    void dumpJackets() throws IOException {
        for (Iterator<List<String>> it = readCsvJacket(); it.hasNext(); ) {
            List<String> item = it.next();
            System.out.println("item: " + item);
        }
    }

    @Test
    void dumpOthers() throws IOException {
        for (Iterator<List<String>> it = readCsvOtherProducts(); it.hasNext(); ) {
            List<String> item = it.next();
            System.out.println("item: " + item);
        }
    }
}
