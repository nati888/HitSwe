package Model;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class Excel {
    private static Workbook workbook;
    private static Sheet sheet,sheet1;
    public static void add_Worker_To_Excel(Model.Worker new_worker) {
        ArrayList<String> A = new ArrayList<>();
        String excelFilePath = "Workers_data.xlsx";
        Model.Department dp;

        int i = 1;

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            sheet = workbook.getSheetAt(0);
            String ID_Person = String.valueOf(new_worker.getIDperson());
            String num_Worker = String.valueOf(new_worker.getNum_Worker());
            String dep_ID = String.valueOf(new_worker.getDepartment_ID());
            String exp = String.valueOf(new_worker.getExperience());
            String base_Salary = String.valueOf(new_worker.getBase_Salary());
            String hours = String.valueOf(new_worker.getHours());
            String job_ID = String.valueOf(new_worker.getJob_ID());


            Object[][] bookData = {
                    {ID_Person, new_worker.getLast_name(), new_worker.getFirst_name(), num_Worker , dep_ID, exp, base_Salary, hours, new_worker.getAssessment(), new_worker.getPassword(), job_ID},

            };
            int i1 = 2;
            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 1;

                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }

            }
            System.out.println("Added worker to the excel");
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Workers_data.xlsx");

            workbook.write(outputStream);

            workbook.close();
            outputStream.close();


        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }
    public static void fired_Workers_Excel(Model.Worker worker){
        ArrayList<String> A = new ArrayList<>();
        String excelFilePath1 = "Fired_workers_data.xlsx";
        Model.Department dp;

        int i = 0;

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath1));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet1 = workbook.getSheetAt(0);
            String ID_Person = String.valueOf(worker.getIDperson());
            String num_Worker = String.valueOf(worker.getNum_Worker());
            String dep_ID = String.valueOf(worker.getDepartment_ID());
            String exp = String.valueOf(worker.getExperience());
            String base_Salary = String.valueOf(worker.getBase_Salary());
            String hours = String.valueOf(worker.getHours());
            String job_ID = String.valueOf(worker.getJob_ID());


            Object[][] bookData = {
                    {ID_Person, worker.getLast_name(), worker.getFirst_name(), num_Worker, dep_ID, exp, base_Salary, hours, worker.getAssessment(),worker.getPassword(), job_ID},

            };

            int rowCount = sheet1.getLastRowNum();

            for (Object[] aBook : bookData) {
                Row row1 = sheet1.createRow(++rowCount);

                int columnCount = 1;

                Cell cell1 = row1.createCell(columnCount);
                cell1.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell1 = row1.createCell(++columnCount);
                    if (field instanceof String) {
                        cell1.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell1.setCellValue((Integer) field);
                    }
                }

            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Fired_workers_data.xlsx");

            workbook.write(outputStream);

            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
    public static void clear_Excel() throws IOException {
        String excelFilePath = "Workers_data.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            deleteRow(sheet, row);
        }
        System.out.println("Deleting all... ");

        inputStream.close();

        FileOutputStream outFile = new FileOutputStream(new File("Workers_data.xlsx"));
        workbook.write(outFile);
        outFile.close();


//...
    }
    public static void deleteRow(Sheet sheet, Row row) {
        int lastRowNum = sheet.getLastRowNum();
        if(lastRowNum !=0 && lastRowNum >0) {
            int rowIndex = row.getRowNum();
            Row removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);

            }
        }
    }
    public static void read_From_Workers_Data(){

        String excelFilePath = "Workers_data.xlsx";
//obtaining input bytes from a file

        {
            File file = new File(excelFilePath);   //creating a new file instance
            FileInputStream fis = null;   //obtaining bytes from the file
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = null;
            try {
                wb = new XSSFWorkbook(fis);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    printCellValue(cell);
                }
                System.out.println("");
            }
        }

    }
    public static void read_From_Fired_Workers_Data() {
        String excelFilePath1 = "Fired_workers_data.xlsx";
//obtaining input bytes from a file

        {
            File file = new File(excelFilePath1);   //creating a new file instance
            FileInputStream fis = null;   //obtaining bytes from the file
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = null;
            try {
                wb = new XSSFWorkbook(fis);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    printCellValue(cell);
                }
                System.out.println("");
            }
        }

    }
}

