package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProctorProfilePage extends BasePageClass {

	public ProctorProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='position-relative ng-star-inserted']")
	WebElement profileIcon;
	@FindBy(xpath = "//div[@class='dropdown-item' and normalize-space(text())='Logout']")
	WebElement logout;
	@FindBy(xpath = "//h2[normalize-space()='Profile Completion']")
	WebElement isVisibleProfileCompletion;

	public void clickOnProfile() {
		profileIcon.click();
	}

	public void clickOnLogout() {
		logout.click();
	}

	public boolean visibilityOfProfileCompletion() {
		return isVisibleProfileCompletion.isDisplayed();

	}

	public void clickOnTheProfilePage() {
		isVisibleProfileCompletion.click();
	}

}
