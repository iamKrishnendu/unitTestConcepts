package Runner;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BrowserHandler;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features= {"src/test/resources/features"},
		format = {"pretty", "html:target/Destination"},
		glue="stepDefination",
		tags = {"@Smoke,@Regression"}
		
		)


public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeTest
	@Parameters("browser")
	public void configuration(@Optional("CHROME") String browser)  
	{  
			BrowserHandler handler = new BrowserHandler(browser);
			System.out.println(String.format("%s accessed", handler.getClass().getName()));
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("under teardown");
		BrowserHandler.closeApplication();
	}

}
