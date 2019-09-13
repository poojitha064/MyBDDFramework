
package testing.com.ola.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
public WebDriver driver;
public static final int MAX_TIMEOUT = 60;

public BasePage(WebDriver driver) {
 this.driver = driver;
}

public Boolean waitUntil(ExpectedCondition condition) {

 WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
 try {
  wait.until(condition);
  return true;
 } catch (Exception e) {
  return false;
 }

}

public void elementClick(WebElement ele) {

 if (waitUntil(ExpectedConditions.elementToBeClickable(ele)))
  ele.click();
}

public void sendtxt(WebElement ele, String txt) {
 if (waitUntil(ExpectedConditions.visibilityOf(ele)))
  ele.sendKeys(txt);
}

public void verifyResult(String actual, String expected, String field) {

 Assert.assertTrue(field + " does not match. Expected --> " + expected + ". Actual --> " + actual,
   expected.equals(actual));

}

public String getDate() {
 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
 Date date = new Date();
 return dateFormat.format(date);
}

public void takeScreenshot(String path, String name) {
 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 String s = new SimpleDateFormat("MM_dd_HH_mm_ss").format(new Date());

 try {
  FileUtils.copyFile(src, new File(path + "/" + name + s + ".png"));
 } catch (IOException e) {

  e.printStackTrace();

 }

}

public void scrollToElement(WebElement ele) throws IllegalAccessException {

 JavascriptExecutor executor = (JavascriptExecutor) driver;
 executor.executeScript("arguments[0].scrollIntoView();", ele);
}

public void clickElement(WebElement ele) throws IllegalAccessException {

 JavascriptExecutor executor = (JavascriptExecutor) driver;
 executor.executeScript("arguments[0].click();", ele);
}

public void sendText(WebElement ele, String inputText) throws IllegalAccessException {

 JavascriptExecutor executor = (JavascriptExecutor) driver;

 executor.executeScript("arguments[0].setAttribute('value', '" + inputText + "')", ele);

}

public String incrementHours(String date, int hours, int minutes) throws Exception {
 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
 try {
  Date dat = dateFormat.parse(date);
  Calendar c = Calendar.getInstance();
  c.setTime(dat);
  c.add(Calendar.HOUR_OF_DAY, hours);
  c.add(Calendar.MINUTE, minutes);
  return dateFormat.format(c.getTime());
 } catch (ParseException e) {
  throw new Exception("Date Parsing Exception. Please pass valid date format");
 }
}

public void takeScreenshot(String name) {

 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 String s = new SimpleDateFormat("MM_dd_HH_mm_ss").format(new Date());
 String s1 = new SimpleDateFormat("MM_dd").format(new Date());
 String s2 = new SimpleDateFormat("mm_ss").format(new Date());

 File file = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "SDf" + "\\" + s1);
 if (!file.exists()) {
  file.mkdir();
 }

 try {
  FileUtils.copyFile(src, new File(file + "/" + name + s + ".jpg"));
 } catch (IOException e) {

  e.printStackTrace();

 }

}
}

