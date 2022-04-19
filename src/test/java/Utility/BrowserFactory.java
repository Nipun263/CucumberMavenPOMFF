package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver startApplication(WebDriver driver, String browserName) throws InterruptedException {

		String browserPath = System.getProperty("user.dir");

		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserPath + "/Drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					"C:\\Program Files\\DummyLogs\\Firefoxlogs.txt");

			driver = new FirefoxDriver();

			System.out.println("Firefox driver used");
		}

		else if (browserName.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();

			DesiredCapabilities dcap = new DesiredCapabilities(options);

			String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);

			driver = new ChromeDriver();

		}

		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		System.out.println("Driver Called !!!!");

		Thread.sleep(3000);

		return driver;

	}
}
