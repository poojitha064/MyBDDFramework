package runners;

import java.io.File;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)

@CucumberOptions(features = { "classpath:features" }, plugin = { "pretty", "html:output",

		"json:output/System/cucumber_report.json", "junit:output/report.xml", "rerun:output/failures.txt" }, glue = {

				"stepdefinitions" })

public class TestRunner {

	@BeforeClass

	public static void run() {

		File dir = new File(System.getProperty("user.dir") + "//output");

		File newDir = new File(

				dir.getParent() + "\\Archive\\" + DateTime.now(DateTimeZone.UTC).toString().replace(":", "-"));

		dir.renameTo(newDir);

	}
}
