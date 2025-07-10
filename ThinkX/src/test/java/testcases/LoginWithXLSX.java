package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.DataProviders;
import webpages.ProctorLoginPage;
import webpages.ProctorProfilePage;

public class LoginWithXLSX {

	WebDriver driver;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void loginTest(String email, String password, String rowCount) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://thinkproctor-qa.thinkexam.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ProctorLoginPage lp = new ProctorLoginPage(driver);
		SoftAssert sa = new SoftAssert();

		lp.clearEmailField();
		lp.clearPassField();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickOnLogin();

		if (rowCount.equals("valid")) {
			ProctorProfilePage app = new ProctorProfilePage(driver);
			if (app.visibilityOfProfileCompletion()) {
				sa.assertTrue(app.visibilityOfProfileCompletion(), "Profile completion text is visible.");
				app.clickOnProfile();
				app.clickOnLogout();
			} else {
				sa.fail("Profile completion text not visible.");
			}
		}

		sa.assertAll();
		driver.quit();
	}
}
