package testAutomationFramework.util;

import testAutomationFramework.util.DriverType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TestConfigReader {
	private static DriverType dtype;
	
	public TestConfigReader() {	
	//public static void main(String[] args) {
		try {
			File cfg = new File("./src/Config/testconfig.properties");
			FileInputStream fs = new FileInputStream(cfg);
			Properties props = new Properties();
			
			props.load(fs);
			fs.close();
			
			Enumeration enuKeys = props.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = props.getProperty(key);
				
				if(key.equals("testdriver")) {				
					setTestDriver(value);					
				}
				
				System.out.println(key + ": " + value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void setTestDriver(String type) {
		switch(type){		 
		 case "CHROME":
			 dtype = DriverType.TYPE_CHROME;
			 break;
		 case "SAFARI":
			 dtype = DriverType.TYPE_SAFARI;
			 break;
		 case "FIREFOX":
		default:
			dtype = DriverType.TYPE_FIREFOX;
			 break;
		}
		// System.out.println("dtype: " + dtype );
	}
	
	public DriverType getDriverType() {
		return dtype;
	}
}
