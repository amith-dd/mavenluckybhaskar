package datadriventestingpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Create the object for FileInputStream with relative path of the File
		FileInputStream fis = new FileInputStream("./src/test/resources/trellodata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		// Take the access of the sheet in the workbook
		Sheet sheet = workbook.getSheet("dobdata");
		// row limit
		int firstRowIndexCount = sheet.getFirstRowNum();
		System.out.println("firstRowIndexCount: " + firstRowIndexCount);
		int lastRowIndexCount = sheet.getLastRowNum();
		System.out.println("lastRowIndexCount: " + lastRowIndexCount);
	}
}