package datadriventestingpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static void main(String[] args) throws IOException {
		// Step 01: Create an object for FileInputStream and supply the relative path of
		// the file
		FileInputStream fis = new FileInputStream("./src/test/resources/trellodata.properties");
		// Step 02: Create an object for Properties Class of Java
		Properties pobj = new Properties();
		// Step 03: load the inputStream obj members into the new properties Object
		pobj.load(fis);
		// Step 04: get the value from the as per the mentioned key
		String value = pobj.getProperty("url");
		System.out.println(value);
	}
}
