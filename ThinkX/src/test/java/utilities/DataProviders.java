package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import webpages.ProctorLoginPage;

public class DataProviders {
	
	WebDriver driver;
	@DataProvider(name = "LoginData")
	
	public Object[][] getData() throws IOException {

		String excelFilePath = System.getProperty("user.dir") + "\\testdata\\thinkxdata.xlsx";
		int rowCount = ExcelUtills.getRowCount(excelFilePath, "Sheet1");

		Object[][] loginData = new Object[rowCount][3]; // Assuming 2 columns: email, password

		for (int r = 1; r <= rowCount; r++) {
					
			loginData[r - 1][0] = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 0); 
			loginData[r - 1][1] = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 1); 
			loginData[r - 1][2] = (r == rowCount) ? "valid" : "invalid";
		}
		return loginData;
	}

}
