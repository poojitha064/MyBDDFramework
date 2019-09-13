package pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import util.BaseClass;
import util.Log;

public class LoginPage extends BaseClass{

	Logger log = Log.logger;
	public LoginPage(WebDriver driver) {
		super(driver);
		log.info("in login page");
	}

}
