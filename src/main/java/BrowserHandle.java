import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserHandle {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); //[parentId,childId]
		String parentId = it.next(); //it will go with oth index as parentId
		String childId = it.next(); //it will go with 1st index as childId
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".inner-box h1")).getText());
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String getEmailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split(" ")[1];
		driver.switchTo().window(parentId);
		driver.findElement(By.name("username")).sendKeys(getEmailId);
		
		driver.get("https://allendigitaluat.thinkexam.com/admin/");
		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.cssSelector(".nav-line-1-container"))).build().perform();

		action.moveToElement(driver.findElement(By.id("loginId"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
			
		
	}

}
