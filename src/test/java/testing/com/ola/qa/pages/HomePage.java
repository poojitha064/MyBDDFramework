package testing.com.ola.qa.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import testing.com.ola.qa.util.BasePage;
import testing.com.ola.qa.util.Log;

public class HomePage extends BasePage {

public HomePage(WebDriver driver) {
 super(driver);

}

Logger log = Log.logger;;

@FindBy(xpath = "//*[contains(text(),'Test Plans')]")
WebElement lnkTestPlan;

@FindBys(@FindBy(xpath = "//form/table/tbody/tr"))
List<WebElement> table;

public void clickTest(String Plan) {
 log.info("Clicking Test Plan Link...");
 elementClick(lnkTestPlan);
 log.info("Printing");
 System.out.println(table.size());
}

}
