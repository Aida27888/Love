import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Practice17 {

    public static void main(String[] args) throws InterruptedException {

       //  1st Task
        //  Link's Count on the page
        // Give me the count of the link
        // a is a --> (anchor) link tag

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("http://qaclickacademy.com/practice.php");
        // findelementSSSSSS
        System.out.println(driver.findElements(By.tagName("a")).size());  // 27

          // 2nd task
        // COUNT OF FOOTER SECTION

        // find how many link tags on footer section
        // so 1st we define/highlight whole footer section so we can find the main element
        // then we can use that main/ parent element as a MINI Driver (like regular dirver BUT mini )

      WebElement footerDriver =  driver.findElement(By.id("gf-BIG")); // Limitting webdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size()); // 20
         // 3rd Task
        // 1st Column from FOOTER Section

         // so we have our MINI footer section driver
Thread.sleep(3000);
        WebElement columnDriver =footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
    List<WebElement> newLinkName = columnDriver.findElements(By.tagName("a"));

      System.out.println(newLinkName.size());

        // 4th Task
        // Click on each link in the column and check if the pages are opening
      // opening 4 different pages without coming back and forth

        Set <String > abc = driver.getWindowHandles();
 for (int i = 0; i <= newLinkName.size();  i++) {
            // select the control & hits another link & it opens on another ta

            Thread.sleep(2000);

     String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);

     newLinkName.get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(2000);



    Iterator<String> it = abc.iterator();

     while (it.hasNext()){
         driver.switchTo().window(it.next());
         System.out.println(driver.getTitle());

     }
        }





    }
}
