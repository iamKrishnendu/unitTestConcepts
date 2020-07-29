package stepDefination;


import static org.testng.Assert.*;

import org.apache.log4j.Logger;

import Pages.DashboardPage;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginHRM  {
	
Logger log = Logger.getLogger(LoginHRM.class);	
LoginPage lp = new LoginPage();
DashboardPage dp = new DashboardPage();
@Given("^Browser should be open with Orange HRM application$")
public void browser_should_be_open_with_Orange_HRM_application() throws Throwable {
	log.info("Under Given steps to determine Homepage is loaded");
	lp = (LoginPage)lp.navigateTo();
	assertTrue(lp.isLoaded(), String.format("The Login page load status is %s", lp.isLoaded()));
	
	
	
}
	

@When("^User enters a valid username and password to the fields$")
public void user_enters_a_valid_username_and_password_to_the_fields() throws Throwable {
	log.info("Under When steps to validate user is able to enter login credentials");
	assertTrue(lp.enterCredentials("Admin", "admin123"), "Credentials not entered successfully");
}

@When("^Clicks on Login button$")
public void clicks_on_Login_button() throws Throwable {
	log.info("Under When steps to validate user is able to click on Login button");
	assertTrue(lp.clickOnLogin(),"Login button is not clicked successfully");
}

@Then("^User should be on Dashboard page$")
public void user_should_be_on_Dashboard_page() throws Throwable {
	log.info("Under Then steps to validate user is on Dashboard page");
	assertTrue(dp.isLoaded(), "Dashboard page is not loaded");
}


@When("^User enters an invalid \"([^\"]*)\" and \"([^\"]*)\" to the fields$")
public void user_enters_an_invalid_and_to_the_fields(String username, String password) throws Throwable {
	log.info("Under When steps to validate user is able to enter in valid login credentials");
	assertTrue(lp.enterCredentials(username, password), "Credentials not entered successfully");
}

@Then("^User should get error message as \"([^\"]*)\"$")
public void user_should_get_error_message_as(String errorMessage) throws Throwable {
	log.info("Under Then steps to validate the error message of Invalid Credentials");
    assertTrue(lp.checkErrorMessageForInvalidCredentials(errorMessage),"Error message not be checked");
}
@When("^User enters invalid \"([^\"]*)\" and \"([^\"]*)\" to the fields$")
public void user_enters_invalid_and_to_the_fields(String username, String password) throws Throwable {
	log.info("Under When steps to validate user is able to enter in valid login credentials multiple times");
	assertTrue(lp.enterCredentials(username, password), "Credentials not entered successfully");
}

}
