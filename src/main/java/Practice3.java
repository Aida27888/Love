import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class Practice3 {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String name = "rahul";  // not hardcoding we did name is Dynamic

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        Thread.sleep(1000);
        String password = getPassword(driver);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        Thread.sleep(5000);//"rahulshettyacademy"
        driver.findElement(By.id("chkboxOne")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.findElement(By.tagName("p")).getText();

        // Assertion
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        System.out.println(driver.findElement(By.tagName("p")).getText()); // so we can see in our console
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        Thread.sleep(2000);
        //  driver.findElement(By.tagName("button")).click(); // either or //button[text()='Log Out'] or //*[text()='Log Out']
        driver.findElement(By.xpath("//button[text()='Log Out']")).click(); // logging out and back to sign in page
    }


    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(3000);
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();

//Please use temporary password 'rahulshettyacademy' to Login.

        String[] passwordArray = passwordText.split("'");

// String[] passwordArray2 = passwordArray[1].split("'");

// passwordArray2[0]

        String password = passwordArray[1].split("'")[0];

        return password;

//0th index - Please use temporary password

//1st index - rahulshettyacademy' to Login.

//0th index - rahulshettyacademy

//1st index - to Login.

    }
}
