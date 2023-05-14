import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Practice13 {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //     Fluent Wait  topic syntax and etc
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

      WebElement startButton= driver.findElement(By.xpath("//div[@id='start'] //button"));
               startButton .click();
        Wait<WebDriver> wait = new FluentWait<WebDriver> (driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
              if ( driver.findElement(By.xpath("//div[@id='finish']")).isDisplayed()){

                  return driver.findElement(By.xpath("//div[@id='finish']"));
              }else return null;
            }
        });

        System.out.println(driver.findElement(By.xpath("//div[@id='finish']")).getText());









    }
}
