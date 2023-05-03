package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;



public class Driver {
	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	
			String browser = System.getProperty("browser");
			if (browser == null) {
				browser = DataReader.getProperty("browser");
			}
			if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
				switch (browser) {
				case "firefox":
					FirefoxDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					EdgeDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "safari":
					driver = new SafariDriver();
					break;
				case "chrome":
					ChromeDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "headless":
				default:
					ChromeDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					options.addArguments("--window-size=1920,1080");
					driver = new ChromeDriver(options);
				}
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

