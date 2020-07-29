package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import Base.BrowserHandler;
import Base.Constants;
import Interfaces.IPage;

public class DashboardPage implements IPage{
	
	public  DashboardPage() {
		PageFactory.initElements(BrowserHandler.getDriver(), this);
	}

	@Override
	public IPage navigateTo() {
		BrowserHandler.getDriver().get(Constants.HOME_PAGE);
		BrowserHandler.getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		return this;
	}

	@Override
	public boolean isLoaded() {
		if(BrowserHandler.getDriver().getCurrentUrl().equals(Constants.HOME_PAGE.concat(Constants.DASHBOARD)) &&  
				BrowserHandler.getDriver().getTitle().equals(Constants.HOME_PAGE_TITLE))
			return true;
	return false;	
	}
	
	

}
