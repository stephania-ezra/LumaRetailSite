package com.PractisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SauceDemoExcelDataTest {
    public final Logger log = LogManager.getLogger(SauceDemoExcelDataTest.class);

    @DataProvider
    public String[][] sauceDemoExcelData() throws IOException {
        log.info("Testing Excel Data Supplier");
        File excelFile = new File("src\\test\\resources\\SauceDemoData.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowCount - 1][columnCount];
        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < columnCount; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
            log.info("\n");
        }
        workbook.close();
        fis.close();

        return data;
        //for (String[] dataArr : data) {
        //   log.info(Arrays.toString(dataArr));
        //}
        // log.info(Arrays.toString(data));
    }
}
