package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class AutomationExerciseDataProvider {

    private final Logger log = LogManager.getLogger(AutomationExerciseDataProvider.class);
    
    @DataProvider(parallel = true)
    public String[][] automationTestDP() throws IOException {
        File excelFile = new File("src/test/resources/ExcelDataAutomationExercise.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //get Physical number of rows
        //log.info("Number of Rows:{}", sheet.getPhysicalNumberOfRows());
        //excluding the header
        //log.info("Last Number of the Row:{}", sheet.getLastRowNum());
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfColumns];

        for (int i = 0; i < noOfRows - 1; i++) {
            //no.of.columns can be get by header details
            //row number 0 for header
            //getLastCellNum - no.of.columns in the row

            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                //log.info(df.formatCellValue(sheet.getRow(i).getCell(j)));
                //storing the value in data array
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
                //  log.info(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
        workbook.close();
        fis.close();

        return data;
    }


    @Test
    void test1() throws IOException {
        String[][] data = automationTestDP();
        for (String[] dataArray : data) {
            log.info(Arrays.toString(dataArray));
        }
    }
}
