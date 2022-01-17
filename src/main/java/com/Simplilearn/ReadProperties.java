package com.Simplilearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	static Properties properties = null;
	
	public static void loadProperties() throws Throwable {
		if (properties == null) {
			properties = new Properties();
			String projectDirPath = System.getProperty("user.dir");
			String propFilePath = projectDirPath + "/Project.properties";
			
			//File file = new File(propFilePath);
			//System.out.println(file.exists());
			
			InputStream ins = new FileInputStream(propFilePath);
			properties.load(ins);
			
		}
	}
	public static String getProperties(String key) throws Throwable {
		loadProperties();
		return properties.getProperty(key);
	}
//	public static void main(String[] args) throws Throwable {
//		System.out.println(ReadProperties.getProperties("loginUrl"));
//	}

}
