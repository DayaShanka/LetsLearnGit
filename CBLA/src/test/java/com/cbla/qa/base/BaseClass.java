package com.cbla.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Properties testProp;

	public BaseClass() throws IOException {

		testProp = new Properties();
		File file = new File(
				System.getProperty("user.dir") + "\\src\\main\\resources\\com\\cbla\\config\\propertiesFile");
		FileInputStream fip = new FileInputStream(file);
		testProp.load(fip);

	}

	public String getPropertyFromConfig(String key) {
		return testProp.getProperty(key);
	}

	public WebDriver launchBrowser(String browserName) {

		if (browserName == null || browserName.isEmpty()) {

			System.out.println("Browser not found..");
			return null;
		}

		switch (browserName.toLowerCase()) {

		case "chrome":
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions opt = new FirefoxOptions();
			opt.setProfile(profile);
			driver = new FirefoxDriver(opt);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser not found");

		}
		return driver;

	}

	public WebDriver getDriver() {
		return driver;

	}

	@BeforeMethod
	//@Parameters({ "browser" })
	// protected void setup(@Optional("firefox") String browserName) {
	public void setup() {
		this.driver = getDriver();
		 driver = launchBrowser(getPropertyFromConfig("browser"));
		//driver = launchBrowser(br); // using from xml file
		driver.get(getPropertyFromConfig("cblaURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		System.out.println("Setup method executed.");
	}

	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}

}

