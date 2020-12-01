package com.property.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.property.PropReader;

public class ImplDBPropReader implements PropReader{
	
	private Properties properties = new Properties();
	
	public String DB_DRIVER = "";
	public String DB_CONNECTION = "";
	public String DB_ID = "";
	public String DB_PASSWORD = "";
	
	public String LOG4J2_PATH = "";
	
	public void readPropertiese(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
	    properties.load(fis);
	}
	
	public void setProperties() {
		DB_DRIVER		=	(String)properties.get("db.driver");
		DB_CONNECTION	=	(String)properties.get("db.connection");
		
		DB_ID			=	(String)properties.getProperty("db.id");
		DB_PASSWORD		=	(String)properties.getProperty("db.password");
		
		LOG4J2_PATH		=	(String)properties.getProperty("log4j2.path");
	}
}
