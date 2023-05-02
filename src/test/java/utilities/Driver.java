package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class Driver {
	

	public static WebDriver driver;
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		return driver;
	}
	public static void quitDriver() {
		if (driver!=null) {
			driver.quit();
			driver = null;
		}
	}
}
