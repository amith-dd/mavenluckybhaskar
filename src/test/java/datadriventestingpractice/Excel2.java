package datadriventestingpractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2 {
public static void main(String[] args) throws Throwable{
	Workbook workbook=WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
	Sheet sheet=workbook.getSheet("dobdata");
	Row row=sheet.getRow(1);
	short firstCellIndexCount= row.getFirstCellNum();
	System.out.println("firstCellIndexCount: " + firstCellIndexCount);
	short lastCellCount = row.getLastCellNum();
	System.out.println("lastCellCount: " + lastCellCount);
	workbook.close();
}
}
