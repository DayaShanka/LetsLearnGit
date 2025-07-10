package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePageClass {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Back To Login']")
	WebElement backToLogin;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailToSentPassword;
	@FindBy(xpath = "//button[normalize-space()='Request Reset Link']")
	WebElement resetLink;
	@FindBy(xpath = "//div[text()=' Please enter a valid email. ']")
	WebElement errorMsgOnResetPassword;
	@FindBy(xpath = "//div[@aria-label='Password reset email sent successfully.']")
	WebElement passwordResetSuccessMsg;
	@FindBy(xpath = "//h2[normalize-space()='Forgot Password']")
	WebElement forgotPasswordText;

	public void clickOnBackToLoginPage() {
		backToLogin.click();
	}

	public void enterEmailToSentPassword(String emailToResetPassword) {
		emailToSentPassword.sendKeys(emailToResetPassword);
	}

	public void clickOnResetLink() {
		resetLink.click();
	}

	public boolean isResetSuccessMsgVisible() {
		return passwordResetSuccessMsg.isDisplayed();
	}

	public String getResetSuccessMsgText() {
		return passwordResetSuccessMsg.getText();
	}

	public boolean isErrorMsgVisibleOnPasswordReset() {
		return errorMsgOnResetPassword.isDisplayed();
	}

	public boolean forgotPasswordTextVisible() {
		return forgotPasswordText.isDisplayed();
	}

}
