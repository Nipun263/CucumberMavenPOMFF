package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;

public class BrowserFactory {
	
	public static WebDriver driver ;
	
	@Before
	public static WebDriver startApplication(WebDriver driver, String browserName) {
		
		String browserPath = System.getProperty("user.dir");

		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserPath +  "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox driver used");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
		
		return driver ;
	

}
}
