
package testing.com.ola.qa.steps;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testing.com.ola.qa.util.BasePage;
import testing.com.ola.qa.util.IntiWebDriver;
import testing.com.ola.qa.util.Log;
import testing.com.ola.qa.util.Singleton;
import testing.com.ola.qa.util.TestException;
import testing.com.ola.qa.util.WordDoc;

public class Hooks {
IntiWebDriver intiWebDriver;
WebDriver driver;
BasePage basePage;
Scenario scenario;
WordDoc wordDoc;

Log log;

@Before
public WebDriver beforeScenario(Scenario scenario) throws TestException {
 this.scenario = scenario;
 try {
  intiWebDriver = new IntiWebDriver();
  driver = intiWebDriver.newDriver();
  Singleton.getInstance().setDriver(driver);
  basePage = new BasePage(driver);
  log = new Log();
  log.init();
 } catch (TestException e) {

  throw new TestException("Error in Before Hook " + e.getMessage());
 }
 return driver;
}

@After
public void afterSceanrio(Scenario scenario) throws TestException, InvalidFormatException, IOException {

 System.out.println("sdfg" + scenario.getStatus());

 if (scenario.isFailed()) {

  byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

  scenario.embed(screenshot, "image/png");

 }

 driver.quit();
 wordDoc = new WordDoc();
 wordDoc.writeInWord(scenario.getName());
}

}

