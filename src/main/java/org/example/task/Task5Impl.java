package org.example.task;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Task5Impl implements Task5 {

  @Override
  public void execute(Scanner scanner) {
    String input;
    System.out.println("Task 5: Please enter the path to the Excel file or leave empty for default path...");

    input = scanner.nextLine().isEmpty()
        ? "/home/sirakov/Methodia/src/main/resources/excel-spreadsheets/Employee Sample Data.xlsx"
        : scanner.nextLine();
    System.out.println("Task 5 output: Reading an Excel file...");
    readExcelFile(input);
  }

  private static void readExcelFile(String path) {

    try (FileInputStream inputStream = new FileInputStream(path);
         Workbook workbook = new XSSFWorkbook(inputStream)) {

      Sheet sheet = workbook.getSheetAt(0);

      Iterator<Row> rowIterator = sheet.iterator();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();

        int counter = 1;
        while (cellIterator.hasNext()) {
          System.out.print(counter++ + ") ");
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
            case STRING:
              System.out.print(cell.getStringCellValue() + "\t");
              break;
            case NUMERIC:
              System.out.print(cell.getNumericCellValue() + "\t");
              break;
            case BOOLEAN:
              System.out.print(cell.getBooleanCellValue() + "\t");
              break;
            case FORMULA:
              System.out.print(cell.getCellFormula() + "\t");
              break;
            default:
              System.out.print("NO VALUE");
          }
        }
        System.out.println();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
