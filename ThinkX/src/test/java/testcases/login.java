package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.ExcelUtills;

public class login {

	public static void main(String[] args) throws IOException, InterruptedException {


		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://thinkproctor-qa.thinkexam.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				
	
		String excelFilePath = System.getProperty("user.dir") + "\\testdata\\thinkxtestdata.xlsx";

		int rowCount = ExcelUtills.getRowCount(excelFilePath, "Sheet1");
		System.out.println("No. of rows count :- " + rowCount);
		
		int columnCount = ExcelUtills.getCellCount(excelFilePath, "Sheet1", rowCount);
		System.out.println("No. of column count :- " + columnCount);

		for (int r = 1; r <= rowCount; r++) {
			String email = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 0);
			String password = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 1);
		
			driver.findElement(By.xpath("//input[@placeholder='Enter email']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
		
		}

	}
	
	

}
