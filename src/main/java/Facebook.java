import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		

public class Facebook {				
    		
    public static void main(String[] args) {									
        String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";					
//        System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        driver.get(baseUrl);		
        System.out.println(driver.getTitle());
        //click on the "Facebook" logo on the upper left portion		
			driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1iyjqo2 x1n2onr6']")).click();					

			//verify that we are now back on Facebook's homepage		
			if (driver.getTitle().equals("Forgotten Password | Can't Log In | Facebook")) {							
            System.out.println("We are back at Facebook's homepage");					
        } else {			
            System.out.println("We are NOT in Facebook's homepage");					
        }		
				driver.close();		

    }		
}





