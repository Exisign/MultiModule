package com.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	
	private Properties properties = new Properties();
	public static String VALUE = "";
	
	private void readPropertiese(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
	    properties.load(fis);
	}
	
	private void setProperties() {
		VALUE = (String)properties.get("value");
	}

}
