import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllenPlusLoginPage {

    private WebDriver driver;

    public AllenPlusLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String formId, String password, String captcha) {
        driver.findElement(By.name("user")).sendKeys(formId);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.id("reg-code")).sendKeys(captcha);
        driver.findElement(By.id("submit")).click();
    }

    public static void main(String[] args) {
        // Create a WebDriver instance
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        System.out.println(options.getBrowserName());
        System.out.println(options.getBrowserVersion());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Navigate to the AllenPlus login page
        driver.get("https://allenplus.allen.ac.in/login");
        

        // Create an instance of the AllenPlusLoginPage class
        AllenPlusLoginPage loginPage = new AllenPlusLoginPage(driver);

        // Login with the specified credentials
        loginPage.login("1000606939", "dstd#123", "susr");

        // Close the WebDriver instance
//        driver.quit();
    }
}
