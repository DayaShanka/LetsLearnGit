package testcases;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;

	@Parameters(value = { "browser", "url" })
	@BeforeClass(groups = { "Smoke/Sanity", "Regression", "All" })
	// public void setup(String br, String url) {

	public void setup() {
		driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://thinkproctor-qa.thinkexam.com/login");
		// driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Smoke/Sanity", "Regression", "All" })
	public void teardown() {
		driver.quit();

	}

	public String captureSC(String testname) {

		// Date dt= new Date();

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		TakesScreenshot takeSC = (TakesScreenshot) driver;
		File sourceFile = takeSC.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testname + timestamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
