package com.property.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.property.PropReader;

public class ImplFilePropReader implements PropReader{
	
	private Properties properties = new Properties();

	public String FILE_PATH = "";
	public String FILE_DATEFORMAT = "";
	public String FILE_NAME = "";
	public String FILE_EXTENSION = "";

	public String WHOLE_ENCODING = "";
	public String LOG4J2_PATH = "";
	
	public void readPropertiese(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
	    properties.load(fis);
	}
	
	public void setProperties() {
		FILE_PATH		=	(String)properties.getProperty("file.path");
		FILE_DATEFORMAT	=	(String)properties.getProperty("file.dateformat");
		FILE_NAME		=	(String)properties.getProperty("file.name");
		FILE_EXTENSION	=	(String)properties.getProperty("file.extension");
		
		WHOLE_ENCODING	=	(String)properties.getProperty("whole.encoding");
		LOG4J2_PATH		=	(String)properties.getProperty("log4j2.path");
	}

	@Override
	public Properties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
