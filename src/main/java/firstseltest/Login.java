package firstseltest;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Login {
	
//	@Test 
	public void checklogin() {
		
		WebDriver driver  = new ChromeDriver();
		driver.get("https://app.bugbug.io/sign-up/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.findElement(By.name("password1")).click();
	
		
		//div[contains(text(), 'This field is required')]
		
		
		
		
		
		driver.close();
	}

}
