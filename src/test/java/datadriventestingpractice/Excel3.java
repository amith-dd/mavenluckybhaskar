package datadriventestingpractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel3 {
	public static void main(String[] args) throws Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		Sheet sheet = workbook.getSheet("dobdata");
		int firstRowIndexCount = sheet.getFirstRowNum();
		int lastRowIndexCount = sheet.getLastRowNum();
		// No of Row times = no of iterations in for loop 
		for (int i = firstRowIndexCount; i <= lastRowIndexCount; i++) {
			Row row = sheet.getRow(i);
			short firstCellIndexCount = row.getFirstCellNum();
			System.out.println("firstCellIndexCount: " + firstCellIndexCount);
			short lastCellCount = row.getLastCellNum();
			System.out.println("lastCellCount: " + lastCellCount);
			for(short j = firstCellIndexCount;j<lastCellCount;j++) {
				CellType cellType = row.getCell(j).getCellType();
				System.out.println(cellType);
			}
			
		}
		workbook.close();
	}
}
