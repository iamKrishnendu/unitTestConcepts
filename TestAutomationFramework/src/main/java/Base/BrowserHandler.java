package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandler {
	
	private static WebDriver driver;
	
	
	Logger log = Logger.getLogger(BrowserHandler.class);
	public BrowserHandler(String browserName) {
		switch (browserName) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info(String.format("Browser %s has launched successfully", browserName));
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info(String.format("Browser %s has launched successfully", browserName));
			break;
			
		case "FF":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info(String.format("Browser %s has launched successfully", browserName));
			break;
		}
		driver.manage().window().maximize();
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	
	public static void closeApplication() {
		driver.close();
		driver.quit();
	}
	
}
