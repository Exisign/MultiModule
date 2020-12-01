package com.property.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.property.PropReader;

public class ImplThreadPropReader implements PropReader{
	
	private Properties properties = new Properties();
	
	public String MIN_THREAD_COUNT = "";
	public String MAX_THREAD_COUNT = "";
	
	public String OPEN_IP_LIST = "";
	
	public String RECEIVE_DATA_CHECK_TIME_MILISEC = "";
	public String RECEIVE_BOTTEL_NECK_CHECK_TIME_MILISEC = "";
	
	public String SEND_DATA_CHECK_TIME_MILISEC = "";
	public String SEND_BOTTEL_NECK_CHECK_TIME_MILISEC = "";

	@Override
	public void readPropertiese(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
	}

	@Override
	public void setProperties() {
		// TODO Auto-generated method stub
		
	}

}
