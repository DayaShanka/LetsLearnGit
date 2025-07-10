package com.cbla.qa.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cbla.qa.base.BaseClass;
import com.cbla.qa.pages.BasePages;

public class AdminLoginWithPagefactory extends BaseClass {

	public AdminLoginWithPagefactory() throws IOException {
		super();
	}
	
	
	
	@Test
	public void loginAndclickOnModules() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginId")));
		WebElement enterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement clickOnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'loginSubmit2']")));
		enterEmail.sendKeys(getPropertyFromConfig("email"));
		enterPassword.sendKeys(getPropertyFromConfig("password"));
		clickOnLogin.click();
		System.out.println("Logged in successfully..");
		
		BasePages module = new BasePages(driver);
		module.clickOnCandidate();
		module.clickOnProduct();
		module.clickOnQuestion();
		module.clickOnTestmanager();
		module.clickOnSpeaking();
		module.clickOnReports();
		
	}

}
