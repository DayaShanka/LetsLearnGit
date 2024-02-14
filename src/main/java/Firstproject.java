import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Firstproject {

	public static void main(String[] args) {


//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver();

		driver.get("https://allendigitaluat.thinkexam.com/admin/");
		driver.findElement(By.id("loginId")).sendKeys("rohit.katyayan@gingerwebs.in\r\n");
		driver.findElement(By.id("password")).sendKeys("@6m1n#123$");
		driver.findElement(By.id("loginSubmit")).click();
		driver.findElement(By.id("mainmenu_Test_Manager")).click();
		


		
		
	}

}
