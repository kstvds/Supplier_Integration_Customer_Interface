package lib;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utility.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.interactions.Actions;

public class DriverAndObjectDetails {
	public static DesiredCapabilities dc;
	public static WebDriver wd;
	static DriverName driver;
	static Configuration Config = new Configuration();

	public enum DriverName {
		IE, CH, FF, SF
	}

	public DriverAndObjectDetails(DriverName driver) {
		this.driver = driver;
		System.out.println(driver);
	}

	public static WebDriver CreateDriver() {
		try {
			switch (driver) {
			case IE:
				dc = new DesiredCapabilities();
				System.setProperty("webdriver.ie.driver", Config.getIEPath());
				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				wd = new InternetExplorerDriver(dc);
				wd.manage().window().maximize();
				return wd;
			case CH:
				ChromeOptions chromeOptions = new ChromeOptions();
				// dc = new DesiredCapabilities();
				System.setProperty("webdriver.chrome.driver", Config.getChromePath());
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-web-security");
				chromeOptions.addArguments("--no-proxy-server");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				chromeOptions.setExperimentalOption("prefs", prefs);
				wd = new ChromeDriver(chromeOptions);
				return wd;
			case FF:
				wd = new FirefoxDriver();
				wd.manage().window().maximize();
				return wd;
			}
			return null;
		} catch (Exception e) {
			return null;

		}
	}

}
