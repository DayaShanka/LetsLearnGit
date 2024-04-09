import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnrollmentNoAndPassword {

    public static void main(String[] args) {
        // Create an ArrayList to store the enrollment numbers
        ArrayList<Long> enrollmentNos = new ArrayList<>();
        enrollmentNos.add(1000606939L);
        enrollmentNos.add(1000606940L);
        enrollmentNos.add(1000606941L);

        // Create an ArrayList to store the passwords
        ArrayList<String> passwords = new ArrayList<>();
        passwords.add("dstd#123");
        passwords.add("dstd#124");
        passwords.add("dstd#125");

        // Create an ArrayList to store the captcha codes
        ArrayList<String> captchaCodes = new ArrayList<>();
        captchaCodes.add("susr");
        captchaCodes.add("susr");
        captchaCodes.add("susr");

        // Set the ChromeOptions to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver(options);

        // Get the URL of the website
        driver.get("https://allendigitaluat.thinkexam.com/");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Iterate over the enrollment numbers, passwords, and captcha codes
        for (int i = 0; i < enrollmentNos.size(); i++) {
            // Find the enrollment number field and enter the enrollment number
            WebElement enrollmentNoField = driver.findElement(By.name("user"));
            enrollmentNoField.sendKeys(String.valueOf(enrollmentNos.get(i)));

            // Find the password field and enter the password
            WebElement passwordField = driver.findElement(By.name("pass"));
            passwordField.sendKeys(passwords.get(i));

            // Find the captcha code field and enter the captcha code
            WebElement captchaCodeField = driver.findElement(By.id("reg-code"));
            captchaCodeField.sendKeys(captchaCodes.get(i));

            // Find the submit button and click it
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // Wait for the page to load
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Schedule")));
        }

        // Close the WebDriver instance
        driver.quit();
    }
}
