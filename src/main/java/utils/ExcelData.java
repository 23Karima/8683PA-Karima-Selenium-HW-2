package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelData {

    private final String filePath;
    private XSSFWorkbook workbook = null;
    private Sheet sheet = null;
    private Row row = null;
    private Cell cell = null;
    private FileOutputStream fos = null;
    private int numberOfRows, numberOfCol;

    public ExcelData(String filePath) {
        this.filePath = filePath;
    }

    public HashMap<String, String> getDataModel(String sheetName) {
        HashMap<String, String> data = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(numberOfRows).getLastCellNum();

        String[][] tempData = new String[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < 2; j++) {
                cell = row.getCell(j);
                String cellData = getCellValue(cell);
                tempData[i-1][j] = cellData;
            }
        }

        for (String[] row: tempData) {
            String key = row[0];
            String value = row[1];
            data.put(key, value);
        }

        return data;
    }

    public String[][] readStringArrays(String sheetName) {
        String[][] data;

        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(1).getLastCellNum();

        data = new String[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                cell = row.getCell(j);
                String cellData = (String) (getCellValue(cell));
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    public int[][] readIntegerArrays(String sheetName) {
        int[][] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(1).getLastCellNum();

        data = new int[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                cell = row.getCell(j);
                int cellData = Integer.parseInt(getCellValue(cell));
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    public String[] readStringArray(String sheetName) {
        String[] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new String[numberOfRows];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            String cellData = (String) getCellValue(cell);
            data[i - 1] = cellData;
        }

        return data;
    }

    public int[] readIntegerArray(String sheetName) {
        int[] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new int[numberOfRows];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            int cellData = Integer.parseInt(getCellValue(cell));
            data[i-1] = cellData;
        }
        return data;
    }

    public List<String> readStringList(String sheetName) {
        List<String> data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new ArrayList<>();

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            String cellData = (String) getCellValue(cell);
            data.add(i-1, cellData);
        }
        return data;
    }

    public void writeStringArrays(String[][] data, String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.length; i++) {
            row = sheet.createRow(i + 1);

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try {
            fos = new FileOutputStream(this.filePath);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Unable to close file resource");
            e.printStackTrace();
        }
    }

    public void writeIntegerArrays(int[][] data, String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.length; i++) {
            row = sheet.createRow(i + 1);

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try {
            fos = new FileOutputStream(this.filePath);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Unable to close file resource");
            e.printStackTrace();
        }
    }

    private String getCellValue(Cell cell) {
        Object value;

        CellType dataType = cell.getCellType();
        switch (dataType) {
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            default:
                value = cell.getRichStringCellValue();
        }
        return value.toString();
    }
}
