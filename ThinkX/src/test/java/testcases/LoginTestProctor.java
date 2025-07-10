package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import webpages.ForgotPasswordPage;
import webpages.ProctorLoginPage;
import webpages.ProctorProfilePage;
import webpages.ResetPasswordPage;

public class LoginTestProctor extends BaseTest {

	@Test(priority = 1)
	public void verifyForgotPassword() throws InterruptedException {
		ProctorLoginPage lp = new ProctorLoginPage(driver);
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		SoftAssert sa = new SoftAssert();
		Thread.sleep(1000);
		lp.clickOnForgotPasswordLink();
		Thread.sleep(1000);
		sa.assertTrue(fpp.forgotPasswordTextVisible());
		fpp.clickOnBackToLoginPage();
		Thread.sleep(1000);
		lp.clickOnForgotPasswordLink();
		fpp.clickOnResetLink();
		Thread.sleep(1500);
		sa.assertTrue(fpp.isErrorMsgVisibleOnPasswordReset());
		Thread.sleep(1500);
		fpp.enterEmailToSentPassword("daya.shankar@thinkexam.com");
		fpp.clickOnResetLink();
		Thread.sleep(2000);
		sa.assertTrue(fpp.isResetSuccessMsgVisible());
		System.out.println(fpp.getResetSuccessMsgText());
		sa.assertAll();
	}

	@Test(dataProvider = "datasuppliernegative", priority = 2)

	public void verifyWithInvalidCredentials(String email, String password) throws InterruptedException {

		ProctorLoginPage lp = new ProctorLoginPage(driver);
		SoftAssert sa = new SoftAssert();
		lp.clearEmailField();
		lp.clearPassField();
		lp.enterEmail(email);
		Thread.sleep(1000);
		lp.enterPassword(password);
		Thread.sleep(1000);
		lp.clickOnLogin();
		try {
			List<WebElement> errorMessages = lp.isErrorMsgVisible();
			for (WebElement e : errorMessages) {
				sa.assertTrue(e.isDisplayed(), "error message not visible");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sa.assertAll();
	}

	@Test(dataProvider = "datasupplierpositive", priority = 3)

	public void verifyWithValidCredentials(String email, String password) throws InterruptedException {

		ProctorLoginPage lp = new ProctorLoginPage(driver);

		lp.clearEmailField();
		lp.clearPassField();
		lp.enterEmail(email);
		Thread.sleep(1000);
		lp.enterPassword(password);
		Thread.sleep(1500);
		lp.clickOnLogin();
		Thread.sleep(1000);
		System.out.println(lp.getTextOfSuccessLogin());
		ProctorProfilePage app = new ProctorProfilePage(driver);
		boolean ProfileCompletion = app.visibilityOfProfileCompletion();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(ProfileCompletion);
		app.clickOnProfile();
		Thread.sleep(1000);
		app.clickOnLogout();
		System.out.println("Logout successful.");
		sa.assertAll();

	}

	@Test(dataProvider = "resetpassnegativeandpositive", priority = 4, enabled = true)
	public void verifyResetPassword(String newPassword, String confirmPassword) throws InterruptedException {

		driver.get(
				"https://thinkproctor-qa.thinkexam.com/reset-password?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjE5LCJwYXNzSWQiOjExNSwicm9sZSI6InByb2N0b3IiLCJleHAiOjE3NTIxMzkxNTd9.EbfOkd4gy8tk9pDDHF3sNtrkDaOOo-QZMQkCzEqVGeY");
		ResetPasswordPage rpp = new ResetPasswordPage(driver);
		SoftAssert sa = new SoftAssert();
		Reporter.log("Navigated to Reset Password page", true);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		sa.assertTrue(rpp.isresetPasswordTextVisible(), "Reset Password text not visible");
		// rpp.clickOnResetPassButton();
		try {
			List<WebElement> errorMessages = rpp.isErrorMsgVisible();
			for (WebElement e : errorMessages) {
				sa.assertTrue(e.isDisplayed(), "error message not visible");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(1000);
		rpp.enterNewPass(newPassword);
		Reporter.log("Entered new password: " + newPassword, true);
		Thread.sleep(1000);
		rpp.clickOnOutside();
		Thread.sleep(1000);
		rpp.enterConfirmPass(confirmPassword);
		Reporter.log("Entered confirm password: " + confirmPassword, true);
		Thread.sleep(1000);
		rpp.clickOnOutside();
		Thread.sleep(1000);
		rpp.clickOnResetPassButton();
		Thread.sleep(1000);
		try {
			wait.until(ExpectedConditions.visibilityOf(rpp.getPasswordChangedSuccessMessage()));
			sa.assertTrue(rpp.getPasswordChangedSuccessMessage().isDisplayed(), "Success message is not visible.");
			System.out.println("Success Message: " + rpp.ResetSuccessMessageText());
			Reporter.log("Password changed successfully with: " + newPassword + " / " + confirmPassword, true);
		} catch (TimeoutException e) {
			Reporter.log("Success message not visible. Checking for error messages.", true);
			System.out.println("Success message not visible during reset password with mismatch password.");
		}
		sa.assertAll();

	}

	@DataProvider
	public Object[][] datasuppliernegative() {

		Object[][] negativeData = {

				{ "shubham@gmail.com", "shubh@1234" }, { "", "Subh@123" }, { "Shubham@gmail.com", "" }, { "", "" } };

		return negativeData;
	}

	@DataProvider(indices = { 0 })
	public Object[][] datasupplierpositive() {

		Object[][] positiveData = { { "daya.shankar@thinkexam.com", "Daya@1234567" },
				{ "DAYA.SHANKAR@THINKEXAM.COM", "123456" } };

		return positiveData;
	}

	@DataProvider
	public Object[][] resetpassnegativeandpositive() {
		Object[][] negativeAndPostiveData = { { "daya@123", "Daya@123" }, { "Daya@123456", "Daya@123456" } };

		return negativeAndPostiveData;

	}

}
