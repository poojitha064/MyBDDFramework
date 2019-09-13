
package testing.com.ola.qa.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class IntiWebDriver {

protected WebDriver driver;

public WebDriver newDriver() throws TestException {
 try {
  switch (new PropertiesUtil("Configure").getProperty("browser").toLowerCase()) {
  case "chrome":
   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libs\\chromedriver.exe");
   driver = new ChromeDriver();
   break;
  default:
   Assert.fail("Browser May not be configured or invaild browser passed");
  }

  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

 } catch (Exception e) {
  throw new TestException("Error in inintialization Browser" + e.getMessage());
 }
 return driver;
}
}
