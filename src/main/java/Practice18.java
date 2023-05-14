import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;
import java.util.List;

public class Practice18 {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
     //
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,1000)");

        // Calendar locator

        // April 14

        // Break down into multiple task

        // Issue is Needs to be scrolled down!!!


       WebElement target = driver.findElement(By.xpath(".//*[@id='form-field-travel_comp_date']"));

        target.click();
        Thread.sleep(2000);
Boolean flag = driver.findElement(By.xpath("//div[@class='flatpickr-month']//div[@class='flatpickr-current-month']")).getText().contains("June");
        Thread.sleep(2000);

        while ( ! driver.findElement(By.xpath("//div[@class='flatpickr-month']//div[@class='flatpickr-current-month']")).getText().contains("June") )
        { Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='flatpickr-month'] //span[@class='flatpickr-next-month']")).click();
            Thread.sleep(2000);
        }
      List<WebElement> dates=  driver.findElements(By.cssSelector("span[class='flatpickr-day ']"));
      int count =  driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).size();

      for(int i =0; i<count; i++ )
      {
         String text = driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).get(i).getText();
         if(text.equalsIgnoreCase("13")){
             System.out.println(text);
             driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).get(i).click();
             break;

         }
      }



    }
}
