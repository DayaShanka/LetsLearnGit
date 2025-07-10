package webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProctorLoginPage extends BasePageClass {

	public ProctorLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter email']")
	WebElement email;
	@FindBy(xpath = "//input[@placeholder='Enter password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@aria-label='Login successful']")
	WebElement successLogin;
	@FindBy(xpath = "//div[@aria-label='Invalid email or password'] | "
			+ "//div[normalize-space()='Password is required.'] | "
			+ "//div[normalize-space()='Please enter a valid email.'] | " + "//div[@class='error ng-star-inserted']")
	List<WebElement> errorMessages;
	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	WebElement forgotPassword;

	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}

	public void enterPassword(String passwordid) {
		password.sendKeys(passwordid);
	}

	public void clickOnLogin() {
		loginButton.click();
	}

	public void clearEmailField() {
		email.clear();
	}

	public void clearPassField() {
		password.clear();
	}

	public boolean isSuccessMsgVisible() {
		return successLogin.isDisplayed();
	}

	public List<WebElement> isErrorMsgVisible() {
		return errorMessages;
	}

	public void clickOnForgotPasswordLink() {
		forgotPassword.click();
	}

	public String getTextOfSuccessLogin() {
		return successLogin.getText();
	}
}
