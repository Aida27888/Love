import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Practice19 {


    public static void main(String[] args) throws InterruptedException {


        //How to Perform Scrolling with in table and
        // Window level using JavaScriptExecutor


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("http://qaclickacademy.com/practice.php");

        JavascriptExecutor js = (JavascriptExecutor) driver; // casting my driver to jsexecutor and executes
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);

        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

      List<WebElement> values =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));


      int  sum =0;
        for (int i=0 ; i < values.size(); i++ )
        {
            sum+= Integer.parseInt(values.get(i).getText()) ; // parsing since it is an Integer

        }

        System.out.println(sum);
       driver.findElement(By.cssSelector("div.totalAmount")).getText();
                    // Total Amount Collected: 296
    int total = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());

     Assert.assertEquals(sum, total );


    }
}
