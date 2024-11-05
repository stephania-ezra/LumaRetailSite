package org.luma.learning;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.luma.App.log;

public class ReadExcelTest {

    public static void main(String[] args) throws IOException {

        //displaying one cell in a row
        //create one file instance
        File file = new File("C:\\Automation\\ExcelFiles\\ExcelReadTesting.xlsx");

        //Read data from the file
        FileInputStream fis = new FileInputStream(file);

        //Give raw data to workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //Get the sheet inside the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Get the row in the sheet, cell in the sheet , cell value
        String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();

        // printing the cell value
        log.info(cellValue);

        //close the workbook
        workbook.close();

        //close the Input stream
        fis.close();
    }
}