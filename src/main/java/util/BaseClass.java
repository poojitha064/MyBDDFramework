package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public WebDriver driver;
	public static final int MAX_TIMEOUT = 60;
	public PropertiesUtil propUtil = new PropertiesUtil();
public DriverSupplier driverSupplier;
	public void initDriver() {
		try{
			driverSupplier = new DriverSupplier();
			driver = driverSupplier.initDriver();
		} catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		BaseClass bs = new BaseClass();
		bs.initBrowser();
	}

	public void initBrowser() {
		try {
			System.out.println(propUtil.getProperty("config", "Browser"));
		} catch (TestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Boolean waitUntil(ExpectedCondition condition) {

		WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
		try {
			wait.until(condition);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
