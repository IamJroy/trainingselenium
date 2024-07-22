package utilities;


import org.testng.annotations.DataProvider;

public class excelValueProvider {

	@DataProvider(name = "excelValue")
    public Object[][] getExcelData() {
        int rowCount = excelUtilities.rowCount();
        Object[][] cellValue = new Object[rowCount][2];

        for (int i = 1; i < rowCount; i++) {
        	cellValue[i][0] = excelUtilities.getCellValue(i, 0);
        	cellValue[i][1] = excelUtilities.getCellValue(i, 1);
        }

        return cellValue;
    }
}

