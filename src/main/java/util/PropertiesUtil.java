package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	public String getProperty(String fileName, String key) throws TestException {
		Properties properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/test/resources/testdata/" + fileName + ".properties");
			properties.load(fis);
			return properties.get(key).toString();
			
		} catch (FileNotFoundException e) {
			throw new TestException("Unable to find Properties file!! " + e.getMessage());
		} catch (IOException e1) {
			throw new TestException("Unable to read data from Properties file!! " + e1.getMessage());
		}
	}
}
