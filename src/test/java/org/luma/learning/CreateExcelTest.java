package org.luma.learning;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelTest {

    public static void main(String[] args) throws IOException {
        /*HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("First");
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Monday");
        sheet.getRow(0).createCell(1).setCellValue("4/11/2024");
        sheet.getRow(0).createCell(2).setCellValue("Ethan");
        sheet.getRow(0).createCell(3).setCellValue("true");
        sheet.getRow(0).createCell(4).setCellValue("22.7");
        sheet.getRow(0).createCell(4).setCellValue("11:00");
        sheet.getRow(0).createCell(4).setCellValue("&&");
        sheet.getRow(0).createCell(4).setCellValue("2025");

        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Tuesday");
        sheet.getRow(1).createCell(1).setCellValue("5/11/2024");
        sheet.getRow(1).createCell(2).setCellValue("Maggie");
        sheet.getRow(1).createCell(3).setCellValue("False");
        sheet.getRow(1).createCell(4).setCellValue("26.7");
        sheet.getRow(1).createCell(4).setCellValue("10:00");
        sheet.getRow(1).createCell(4).setCellValue("%%");
        sheet.getRow(1).createCell(4).setCellValue("2026");

        File file = new File("C:\\Automation\\ExcelFiles\\FirstExcel.xls");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();*/

        //newer version
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("First");
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Monday");
        sheet.getRow(0).createCell(1).setCellValue("4/11/2024");
        sheet.getRow(0).createCell(2).setCellValue("Ethan");
        sheet.getRow(0).createCell(3).setCellValue("true");
       /* sheet.getRow(0).createCell(4).setCellValue(22.7);
        sheet.getRow(0).createCell(4).setCellValue("11:00");
        sheet.getRow(0).createCell(4).setCellValue("&&");*/
        sheet.getRow(0).createCell(4).setCellValue(2025);

        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Tuesday");
        sheet.getRow(1).createCell(1).setCellValue("5/11/2024");
        sheet.getRow(1).createCell(2).setCellValue("Maggie");
        sheet.getRow(1).createCell(3).setCellValue("False");
        /*sheet.getRow(1).createCell(4).setCellValue("26.7");
        sheet.getRow(1).createCell(4).setCellValue("10:00");
        sheet.getRow(1).createCell(4).setCellValue("%%");*/
        sheet.getRow(1).createCell(4).setCellValue(2026);

        File file = new File("C:\\Automation\\ExcelFiles\\SecondExcel.xlsx");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();
    }
}
