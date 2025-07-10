package com.cbla.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePages {
	
	WebDriver driver;
	
	@FindBy(xpath="//li[@id='mainmenu_Question_Bank']")
	WebElement question;
	@FindBy(xpath="//li[@id='mainmenu_Test_Manager']//span[contains(text(),'Test Manager')]")
	WebElement testManager;
	@FindBy(xpath="(//span[contains(text(),'Product')])[1]")
	WebElement product;
	@FindBy(xpath="(//li[@id='mainmenu_Student']//a[contains(@href, 'pageName=student')]/span[contains(text(), 'Candidate')])[1]")
	WebElement candidate;
	@FindBy(xpath="(//li[@id='mainmenu_Speaking']//a[contains(@href, 'pageName=Speaking')]/span[contains(text(), 'Speaking')])[1]")
	WebElement speaking;
	@FindBy(xpath="(//li[@id='mainmenu_Reports']//a[contains(@href, 'pageName=Rp/testReport')]/span[contains(text(), 'Report')])[1]")
	WebElement reports;
	
	public BasePages(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnQuestion() {
		question.click();
	}
	public void clickOnTestmanager() {
		testManager.click();
	}
	public void clickOnProduct() {
		product.click();
	}
	public void clickOnCandidate() {
		candidate.click();
	}
	public void clickOnSpeaking() {
		speaking.click();
	}
	public void clickOnReports() {
		reports.click();
	}
	
}
