
package testing.com.ola.qa.pages;

import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testing.com.ola.qa.util.BasePage;
import testing.com.ola.qa.util.Log;
import testing.com.ola.qa.util.PropertiesUtil;
import testing.com.ola.qa.util.TestException;

public class LoginPage extends BasePage {

@FindBy(name = "userName")
WebElement txtUserName;

@FindBy(name = "passWord")
WebElement txtPassWord;

@FindBy(xpath = "//*[@value='Submit']")
WebElement btnSubmit;

Logger log = Log.logger;

public LoginPage(WebDriver driver) throws TestException {
 super(driver);

 try {
  PageFactory.initElements(driver, this);
  driver.get(new PropertiesUtil("Configure").getProperty("url"));
 } catch (TestException e) {
  throw new TestException("Error in Login Page " + e.getMessage());
 }
}

public <T> T login(String userName, String Password, Class<T> expectedHomePage) {
 log.info("Entering User Name..");
 sendtxt(txtUserName, userName);
 log.info("Entering Password..");
 sendtxt(txtPassWord, Password);
 log.info("Clicking Submit Button..");
 elementClick(btnSubmit);
 return PageFactory.initElements(driver, expectedHomePage);
}

}

