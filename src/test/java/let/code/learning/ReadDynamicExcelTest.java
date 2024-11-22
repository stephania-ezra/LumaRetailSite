package let.code.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDynamicExcelTest {

    public static Logger log = LogManager.getLogger(ReadDynamicExcelTest.class);

    public static void main(String[] args) throws IOException {

        //create one file instance
        File file = new File("C:\\Automation\\ExcelFiles\\ExcelReadTesting.xlsx");

        //Read data from the file
        FileInputStream fis = new FileInputStream(file);

        //Give raw data to workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //Get the sheet inside the workbook
        XSSFSheet sheet = workbook.getSheetAt(1);

        //dynamic data coming into picture
        //Get number of rows that have value

        int rowCount = sheet.getPhysicalNumberOfRows();
        //iterate through each row

        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            //we can get the row above
            //get number of cells in a row that has value
            int cellCount = row.getPhysicalNumberOfCells();
            //get the cell in the row
            for (int j = 0; j < cellCount; j++) {
                XSSFCell cell = row.getCell(j);
                String cellValue = getCellValue(cell);
                System.out.print("||" + cellValue);
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }

    //getting the value inside the cell and convert it to String
    private static String getCellValue(XSSFCell cell) {
        //enhanced switch
        return switch (cell.getCellType()) {
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> cell.getStringCellValue();
        };

    }
}