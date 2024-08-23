package helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandler {

	public Map<String, String> getTestCaseData(String dataId) {

		// Load the Excel file
		String path = "TestDataFile.xlsx";
		InputStream is;
		XSSFWorkbook workbook;
		try {
			is = getClass().getClassLoader().getResourceAsStream(path);
			workbook = new XSSFWorkbook(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.EMPTY_MAP;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.EMPTY_MAP;
		}
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// ➤ Get the data from excel sheet using Apache poi

		XSSFRow rowKey = sheet.getRow(0);
		XSSFRow rowValue;
		String rowValueString;
		int rowNum = 1;
		do {
			rowValue = sheet.getRow(rowNum);
			rowValueString = rowValue == null? "null" : rowValue.getCell(0).getStringCellValue();
			rowNum++;
		} while(!dataId.equalsIgnoreCase(rowValueString));
		
		if(rowValue == null) {
			throw new IllegalArgumentException("Incorrect DataId provided");
		}
		
		Map<String, String> propertyMap = new HashMap<>();
		
		for (int i = 0; i < rowKey.getLastCellNum(); i++) {
			
			
			Cell nameCell = rowKey.getCell(i);
            Cell valueCell = rowValue.getCell(i);

            if (valueCell == null || valueCell.getStringCellValue() == null || valueCell.getStringCellValue().length() == 0) {
            	continue;
            }
            
            if (nameCell != null && valueCell != null) {
                String propertyName = nameCell.getStringCellValue();
                String propertyValue = valueCell.getStringCellValue();

                propertyMap.put(propertyName, propertyValue);
            }
        }
		
		
		// Close the workbook and file input stream
		try {
			workbook.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return propertyMap;
	}
}
