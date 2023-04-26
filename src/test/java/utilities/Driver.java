package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
