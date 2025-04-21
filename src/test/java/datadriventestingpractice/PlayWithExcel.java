package datadriventestingpractice;

import com.trello.qspiders.genericutility.ExcelUtility;

public class PlayWithExcel {	
	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		System.out.println(new ExcelUtility().getDataFromCell("dobdata", 2, 5));
	}
}
