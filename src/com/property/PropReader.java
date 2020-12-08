package com.property;

import java.io.IOException;
import java.util.Properties;

public interface PropReader {
	public void readPropertiese(String path) throws IOException;
	public void setProperties();
	public Properties getProperties();
}
