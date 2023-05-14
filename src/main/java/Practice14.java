import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Practice14 {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5000));

        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);

// moves to Specific element
        WebElement hoverOvr = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        action.moveToElement(hoverOvr).contextClick().build().perform();
//     HELLO KITTY write in searchbox in Amazon
      action.moveToElement( driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))
              .click().keyDown(Keys.SHIFT).sendKeys(" hello").doubleClick().build().perform();

   //   driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();



    }
}
