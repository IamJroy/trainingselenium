package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtilities {
	
	private static XSSFWorkbook workBook;
	private static XSSFSheet sheet;
	
	
	
	public static int rowCount() {
		
		try {
			workBook = new XSSFWorkbook("C:\\Users\\JhunRoyCanete\\eclipse-workspace\\firstSeleniumTest1\\testData\\testData.xlsx");
			sheet = workBook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			System.out.println("Numbers of Rows: " + rowCount);
			
			return rowCount;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
		return rowCount();
		
	}
	
	public static String getCellValue(int rowNum, int colNum) {
		
		try {
			workBook = new XSSFWorkbook("C:\\Users\\JhunRoyCanete\\eclipse-workspace\\firstSeleniumTest1\\testData\\testData.xlsx");
			sheet = workBook.getSheet("Sheet1");
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
			
			if (cell.getCellType() == CellType.STRING) {
				System.out.println(cell.getStringCellValue());
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC) {
				System.out.println(String.valueOf(cell.getNumericCellValue()));
				return String.valueOf(cell.getNumericCellValue());
			} else {
				return "";
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static List<List<String>> getAllValue(){
		List<List<String>> excelValue = new ArrayList<>();
		for (Row row : sheet) {
			List<String> rowValue = new ArrayList<>();
			for (Cell cell : row) {
				if(cell.getCellType() == CellType.STRING) {
					rowValue.add(cell.getStringCellValue());
				} else if(cell.getCellType() == CellType.NUMERIC) {
					rowValue.add(String.valueOf(cell.getNumericCellValue()));
				}else {
					rowValue.add("Unsupported");
				}
			}
			excelValue.add(rowValue);
		}
		System.out.println(excelValue);
		return excelValue;
	}
	
	public static Object[][] getAllValueObj() {
		List<List<String>> excelValue = new ArrayList<>();
		for (Row row : sheet) {
			List<String> rowValue = new ArrayList<>();
			for (Cell cell : row) {
				if(cell.getCellType() == CellType.STRING) {
					rowValue.add(cell.getStringCellValue());
				} else if(cell.getCellType() == CellType.NUMERIC) {
					rowValue.add(String.valueOf(cell.getNumericCellValue()));
				}else {
					rowValue.add("Unsupported");
				}
			}
			excelValue.add(rowValue);
		}
		Object[][] dataArray = new Object[excelValue.size()][];
        for (int i = 0; i < excelValue.size(); i++) {
            List<String> rowObj = excelValue.get(i);
            dataArray[i] = rowObj.toArray(new Object[rowObj.size()]);
        }
        return dataArray;
	}
	
}
