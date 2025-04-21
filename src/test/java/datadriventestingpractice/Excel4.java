package datadriventestingpractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel4 {
	public static void main(String[] args) throws Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		Sheet sheet = workbook.getSheet("dobdata");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		System.out.println(cellType);
	}
}
