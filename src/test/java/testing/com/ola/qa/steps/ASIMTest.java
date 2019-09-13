package testing.com.ola.qa.steps;

//import static testing.com.ola.qa.steps.Hooks.driver;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testing.com.ola.qa.pages.HomePage;
import testing.com.ola.qa.pages.LoginPage;
import testing.com.ola.qa.util.PropertiesUtil;
import testing.com.ola.qa.util.Singleton;
import testing.com.ola.qa.util.TestException;

public class ASIMTest {


LoginPage loginPage;
PropertiesUtil prop;
HomePage homePage;

@Given("User Login into ASIM")
public void user_Login_into_ASIM() {

 try {

  loginPage = new LoginPage(Singleton.getInstance().getDriver());
  prop = new PropertiesUtil("Configure");

  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), HomePage.class);

 } catch (TestException e) {
  Assert.fail("Test Case failed at Login");
 }

}

@When("User traverse to {string}")
public void user_traverse_to(String string) {
 homePage.clickTest(string);
}

@Then("User click on the Execute {string}")
public void user_click_on_the_Execute(String string) {
 Assert.fail("Test Case failed at Login");
}

}
