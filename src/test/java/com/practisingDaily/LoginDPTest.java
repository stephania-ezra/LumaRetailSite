package com.practisingDaily;

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

public class LoginDPTest {

    private final Logger log = LogManager.getLogger("LoginDPTest.class");

    @DataProvider(parallel = true)
    public String[][] loginDetailsData() throws IOException {

        File excelFile = new File("C:\\Users\\steph\\IdeaProjects\\LumaRetailSite\\src\\test\\" +
                "resources\\AutomationData.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfColumns];

        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        workbook.close();
        fis.close();

        return data;
    }


   /* @dataProvider(parallel = true)
    public Object[][] automationData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "collins.einstein@gmail.com";
        data[0][1] = "testing123";

        data[1][0] = "dave@gmail.com";
        data[1][1] = "qwe@)123";

        return data;
    }*/

    @Test
    void test1() throws IOException {
        String[][] data = loginDetailsData();
        for (String[] dataArray : data) {
            log.info(Arrays.toString(dataArray));
        }
    }
}

