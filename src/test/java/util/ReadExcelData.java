package util;

//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	String cellData;

	public String readExcelData(String data) {

		try {
			String values[] = data.split(",");

			// String path = values[0];

			int sheetNumber = Integer.valueOf(values[0]);
			int rowNumber = Integer.valueOf(values[1]);
			int columNumber = Integer.valueOf(values[2]);

			// File file = new File(path);
			FileInputStream fis = new FileInputStream(
					"/Users/zane/Documents/CucumberProjects/pizzahut_part1/pizzahutTestData.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetNumber);
			XSSFRow row = sheet.getRow(rowNumber);
			XSSFCell cell = row.getCell(columNumber);

			cellData = cell.getStringCellValue();

			System.out.println(cellData);

			wb.close();

		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("not seen");
		}

		return cellData;
	}

}
