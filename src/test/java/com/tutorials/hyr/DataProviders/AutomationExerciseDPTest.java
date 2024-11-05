package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Listeners({CustomListener.class})
public class AutomationExerciseDPTest extends BaseUtilTest {

    public final WebDriver driver = new ChromeDriver();
    public final Logger log = LogManager.getLogger(AutomationExerciseDPTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @DataProvider
    public String[][] AutomationTestDP() throws IOException {
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
        /*for (String[] dataArray : data) {
            log.info(Arrays.toString(dataArray));
        }*/
    }
}
