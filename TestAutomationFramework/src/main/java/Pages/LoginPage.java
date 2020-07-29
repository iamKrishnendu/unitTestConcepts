package Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BrowserHandler;
import Base.Constants;
import Interfaces.IPage;

public class LoginPage implements IPage{

	public LoginPage() {
		PageFactory.initElements(BrowserHandler.getDriver(), this);
	}


	//Page Elements followed by Page Factory
	
	@FindBy(id="txtUsername")
	private WebElement usernameTextBox;
	
	@FindBy(id="txtPassword")
	private WebElement passwordTextBox;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	@FindBy(id="spanMessage")
	private WebElement invalidErrorMessage;

	@Override
	public IPage navigateTo() {
		BrowserHandler.getDriver().get(Constants.HOME_PAGE.concat(Constants.LOGIN_PAGE));
		BrowserHandler.getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		return this;
	}

	@Override
	public boolean isLoaded() {
		
		if(BrowserHandler.getDriver().getCurrentUrl().equals(Constants.HOME_PAGE.concat(Constants.LOGIN_PAGE)) &&  BrowserHandler.getDriver().getTitle().equals(Constants.HOME_PAGE_TITLE))
				return true;
		return false;		
	}
	
	public boolean enterCredentials(String username, String password) {
		boolean testFlag = false;
		usernameTextBox = new WebDriverWait(BrowserHandler.getDriver(), Constants.PAGELOAD_TIMEOUT)
		.until(ExpectedConditions.elementToBeClickable(usernameTextBox));
		
		if(usernameTextBox.isDisplayed()) usernameTextBox.sendKeys(username); testFlag = true;
			
		if(passwordTextBox.isDisplayed() && testFlag == true) passwordTextBox.sendKeys(password); testFlag = true;
		
		return testFlag;
		
	}
	
	public boolean clickOnLogin() {
		boolean testFalg = false;
		if(loginButton.isDisplayed()) loginButton.click();  testFalg = true;
		return testFalg;
		
	}
	
	public boolean checkErrorMessageForInvalidCredentials(String expectedErrorMessage) {
		if(invalidErrorMessage.getText().equals(expectedErrorMessage)) return true;
		return false;
	}

	
}
