
package testing.com.ola.qa.runner;

import java.io.File;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)

@CucumberOptions(features = { "classpath:testing/features" }, plugin = {  "pretty", "html:output", "json:output/cucumber.json", "junit:output/report.xml", "rerun:output/failures.txt" }, glue = {

   "testing.com.ola.qa.steps" }, tags = "@test")

public class TestRunner {

@BeforeClass

public static void run() {

 File dir = new File(System.getProperty("user.dir") + "//output");

 File newDir = new File(

   dir.getParent() + "\\Archive\\" + DateTime.now(DateTimeZone.UTC).toString().replace(":", "-"));

 dir.renameTo(newDir);

}
}

