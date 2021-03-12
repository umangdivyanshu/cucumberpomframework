package stepdefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = lp.getPageTitle();
		   System.out.println("Page title is  - " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		 
		   Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(lp.isForgotPasswordLinkPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	  lp.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	   lp.enterPassword(password);
	}

	@When("user clics on login button")
	public void user_clics_on_login_button() {
	   lp.clickLoginButton();
	}



}
