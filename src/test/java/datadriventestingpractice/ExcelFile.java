package datadriventestingpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Create an Object of FileInputStream
		FileInputStream fis = new FileInputStream("./src/test/resources/trellodata.xlsx");
		// Call WorkbookFactory Class of POI Lib
		Workbook workbook = WorkbookFactory.create(fis);
		// Take the access Of the specific sheet
		Sheet sheet = workbook.getSheet("dobdata");
		// Take the access of the specific row
		Row row = sheet.getRow(1);
		// Take the access of the specific cell in the selected row
		Cell cell = row.getCell(6);
		// read the data from the cell
		String cellData = cell.getStringCellValue();
		System.out.println(cellData);
		workbook.close();
	}

}
