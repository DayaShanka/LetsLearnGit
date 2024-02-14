import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.skyscanner.co.in/");
		boolean name = driver.findElement(By.cssSelector(".BpkText_bpk-text__ZmFmY.BpkText_bpk-text--footnote__YmYxN")).isSelected();
		System.out.println(name);

	}

}


