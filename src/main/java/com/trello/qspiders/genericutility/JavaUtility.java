package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaUtility {
	/**
	 * To Read data from property file in the form of Key and value pair.
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws FileNotFoundException, IOException {
		Properties pobj = new Properties();
		pobj.load(new FileInputStream("./src/test/resources/trellodata.properties"));
		String value = pobj.getProperty(key);
		return value;
	}
}
