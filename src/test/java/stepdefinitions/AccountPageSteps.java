package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private AccountPage ap;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable credentialsDataTable) {
	    List<Map<String, String>> credentials = credentialsDataTable.asMaps();
	    String username = credentials.get(0).get("username");
	    String password = credentials.get(0).get("password");
	    
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    ap=lp.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	   String accountPageTitle = ap.getAccountPageTitle();
	   System.out.println("Accounts page title is - " + accountPageTitle );
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable accountSectionTable) {
		List<String> expectedAccountList = accountSectionTable.asList();
		System.out.println("Expected account section list items are - \n" + expectedAccountList);
		
		List<String> actualAccountsList = ap.getAccountSectionItemList();
		System.out.println("Actual account section list items are - \n" + actualAccountsList);
		
		Assert.assertTrue(expectedAccountList.containsAll(actualAccountsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
	  Assert.assertTrue(ap.getAccountSectionCount()==expectedCount);
	}

}
