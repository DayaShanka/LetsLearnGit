import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class AllenD {

	public static void main(String[] args) throws InterruptedException {

		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		System.out.println("Browser: "+options.getBrowserName());
        System.out.println(options.getBrowserVersion());
        
		long formid = 1000606939;
		String psd = "dstd#123";
		String cap = "susr";
	
		driver.get("https://allendigitaluat.thinkexam.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("5")));
		driver.findElement(By.name("user")).sendKeys(String.valueOf(formid));
		driver.findElement(By.name("pass")).sendKeys(String.valueOf(psd));
		driver.findElement(By.id("reg-code")).sendKeys(String.valueOf(cap));
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
//		)
//		Thread.sleep(4000);
//		try {
//		    WebElement element = driver.findElement(By.id("5"));
//		    element.click();
//		} catch (NoSuchElementException e) {
//		    WebElement element1 =  driver.findElement(By.id("6"));
//		    element1.click();
//		}
//		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("5")));
//		ele.click();
//		driver.findElement(By.xpath("//div[@class='modal-body']//img[@class='cancel-icon']")).click();
		System.out.println("Title is: "+driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\"session-modal\"]/div[2]/div/div/button")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement getTitle = driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-sm navbar-dark dash-head p-0 ng-star-inserted'] //span[contains(text(), 'Schedule')]"));
		System.out.println("Getting module: "+getTitle.getText());
		WebElement msg = driver.findElement(By.xpath("//p[@class='kudos-name']"));
		System.out.println("Greeting msg: " + msg.getText());
		
		driver.findElement(By.cssSelector(".nav-link.dropdown-toggle")).click();
		Thread.sleep(1000);
		WebElement g = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		g.click();
		
		
		Thread.sleep(4000);

		String expectedGreeting = String.valueOf(msg);
	if(msg.equals(expectedGreeting)) {
		    System.out.println("Test Completed Successfully");
	} else {
	    System.out.println("Failed");
		}
		

		
       
		driver.quit();
	}
}



