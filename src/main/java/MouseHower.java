import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHower {
    
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.facebook.com/"; 
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action serofAction  = (Action) builder.moveToElement(txtUsername).click();
		
		
		
		
		
		
		
		
//		Action seriesOfActions = builder
//			.moveToElement(txtUsername)
//			.click()
//			.keyDown(txtUsername, Keys.SHIFT)
//			.sendKeys(txtUsername, "hello")
//			.keyUp(txtUsername, Keys.SHIFT)
//			.doubleClick(txtUsername)
//			.contextClick()
//			.build();
//			
//		seriesOfActions.perform() ;
//
//		}
}