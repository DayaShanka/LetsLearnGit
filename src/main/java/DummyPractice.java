import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummyPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		String sitename = driver.findElement(By.xpath("//div[@class='col-sm-8 col-xs-8 col-md-8'] //h1")).getText();
		System.out.println(sitename);
		driver.findElement(By.className("dropdown-toggle")).click();
		List<WebElement> options = driver.findElements(By.className("dropdown-menu"));
		
		for(int i=0; i<options.size(); i++)
		{
			String n= options.get(i).getText();
			System.out.println(n);
		}
		
		
		
		driver.close();

	}

}
