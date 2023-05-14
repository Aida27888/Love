import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Practice16 {


    public static void main(String[] args) throws InterruptedException {


        //  How to handle Frames?
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Actions actions = new Actions(driver);
        // if u wanna know how many iframes in your application then do below
      //     System.out.println(driver.findElements(By.tagName("iframe")).size());
       driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));


       WebElement drag = driver.findElement(By.cssSelector("div[id='draggable']"));

       WebElement drop = driver.findElement(By.cssSelector("div[id='droppable']"));
          Thread.sleep(2000);
        actions.moveToElement(drag).clickAndHold(drag).dragAndDrop(drag, drop).perform();


    }
}
