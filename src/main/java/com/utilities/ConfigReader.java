package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/*
	 * This method is used to load the properties from config.properties file
	 * @return  it returns Properties prop o bject
	 */
	
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
