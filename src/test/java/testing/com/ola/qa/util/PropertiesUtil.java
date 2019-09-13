
package testing.com.ola.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

Properties prop;

public PropertiesUtil(String fileName) throws TestException {
 try {
  prop = new Properties();

  prop.load(new FileInputStream("src/test/resources/testing/testdata/" + fileName + ".properties"));
 } catch (FileNotFoundException e) {
  throw new TestException("Unable to find Properties file!! " + e.getMessage());
 } catch (IOException e1) {
  throw new TestException("Unable to read data from Properties file!! " + e1.getMessage());
 }
}

public String getProperty(String property) {

 return prop.getProperty(property);

}

}