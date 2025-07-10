package com.cbla.qa.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cbla.qa.base.BaseClass;

public class AdminLogin extends BaseClass {
	
	public AdminLogin() throws IOException {
		super();
	}
	
	@Test
	public void loginWithCorrectEmailAndPassword() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginId")));
		WebElement enterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement clickOnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'loginSubmit2']")));
		enterEmail.sendKeys("cblaadmin@cbla.com.au");
		enterPassword.sendKeys("CBLA@321");
		clickOnLogin.click();
		System.out.println("Logged in successfully..");
		
		try {
			WebElement clickOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='mainmenu_Dashboard']//span[contains(text(),'Dashboard')]")));
			System.out.println("Clicked on " + clickOnDashboard.getText());
			clickOnDashboard.click();
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
		
		WebElement clickOnQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='mainmenu_Question_Bank']")));
		System.out.println("Clicked on " + clickOnQuestion.getText());
		if (clickOnQuestion.getText().contains("Question")) {
			clickOnQuestion.click();
		}
		
		
		
		WebElement clickOnTestmanager = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='mainmenu_Test_Manager']//span[contains(text(),'Test Manager')]")));
		System.out.println("Clicked on " + clickOnTestmanager.getText());
		clickOnTestmanager.click();
		WebElement clickOnProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Product')])[1]")));
		System.out.println("Clicked on " + clickOnProduct.getText());
		clickOnProduct.click();
		WebElement clickOnCandidate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@id='mainmenu_Student']//a[contains(@href, 'pageName=student')]/span[contains(text(), 'Candidate')])[1]")));
		System.out.println("Clicked on " + clickOnCandidate.getText());
		clickOnCandidate.click();
		WebElement clickOnSpeaking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@id='mainmenu_Speaking']//a[contains(@href, 'pageName=Speaking')]/span[contains(text(), 'Speaking')])[1]")));
		System.out.println("Clicked on " + clickOnSpeaking.getText());
		clickOnSpeaking.click();
		WebElement clickOnReports = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@id='mainmenu_Reports']//a[contains(@href, 'pageName=Rp/testReport')]/span[contains(text(), 'Report')])[1]")));
		System.out.println("Clicked on " + clickOnReports.getText());
		clickOnReports.click();
	}
	

}
