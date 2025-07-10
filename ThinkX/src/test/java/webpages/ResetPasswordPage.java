package webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePageClass {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[normalize-space()='Reset Password']")
	WebElement resetPasswordText;
	@FindBy(xpath = "//input[@id='new-password']")
	WebElement newPasswordField;
	@FindBy(xpath = "//input[@id='confirm-password']")
	WebElement confirmPasswordField;
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement resetBotton;
	@FindBy(xpath = "//div[@aria-label='Please enter new password'] | "
			+ " //div[@aria-label='Please enter confirm password'] | "
			+ " //div[@aria-label='Password must be at least 8 characters']")
	List<WebElement> alertToastMsg;
	@FindBy(xpath = "//div[@class=\"strength-rule valid\"]/text()")
	List<WebElement> passwordStrengthRule;
	@FindBy(xpath = "//h2[normalize-space()='Password Changed Successfully!']")
	WebElement passChangedSuc;
	@FindBy(xpath = "//div[@aria-label='Password reset successfully']")
	WebElement resetSuccessfullyMsg;

	public boolean isresetPasswordTextVisible() {
		return resetPasswordText.isDisplayed();
	}

	public void enterNewPass(String newPassword) {
		newPasswordField.sendKeys(newPassword);
	}

	public void enterConfirmPass(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}

	public void clearNewPass() {
		newPasswordField.clear();
	}

	public void clearConfirmPass() {
		confirmPasswordField.clear();
	}

	public void clickOnResetPassButton() {
		resetBotton.click();
	}

	public List<WebElement> isErrorMsgVisible() {
		return alertToastMsg;
	}

	public List<WebElement> passwordstrengthrulecheck() {
		for (WebElement pass : passwordStrengthRule) {
			String strengthRule = pass.getText();
		}
		return passwordStrengthRule;

	}

	public void clickOnOutside() {
		resetPasswordText.click();
	}

	public WebElement getPasswordChangedSuccessMessage() {
		return passChangedSuc;
	}

	public String getPasswordChangedSuccessText() {
		return passChangedSuc.getText();
	}

	public String ResetSuccessMessageText() {
		return resetSuccessfullyMsg.getText();

	}

}
