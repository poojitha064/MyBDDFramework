package stepdefinitions;

import java.util.logging.Logger;

import pages.LoginPage;
import util.DriverSupplier;
import util.Log;

public class login {
	
	static Logger log = Log.logger;
	
	public static void main(String[] args) {
		 new Log().init();
		 log = Log.logger;
		DriverSupplier ds = new DriverSupplier();
		ds.initDriver().get("https://www.google.com");
		LoginPage login = new LoginPage();
		//login.
		log.info("in login test");
	}
}
