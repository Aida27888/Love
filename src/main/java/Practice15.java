import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class Practice15 {
// Window Handle concepts-real time example
    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        Thread.sleep(3000);
      driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
      Thread.sleep(2000);
     Set<String> windows  = driver.getWindowHandles();
 Iterator  <String> it = windows.iterator();  // [Parent window to child and back]

     String parentId =   it.next();
   String childId =  it.next(); // if we need more then we just continue w more it.next();
  // then we switching windows by windowId's
        driver.switchTo().window(childId);
        Thread.sleep(2000);
       WebElement childWindwText = driver.findElement(By.cssSelector("p[class='im-para red']"));
       Thread.sleep(2000);
        System.out.println( childWindwText.getText());

//       Thread.sleep(2000);
//        driver.switchTo().window(childId);

        // HERE we r going to extract only email address
        // so we will use SPLIT method we will cut and get index

        Thread.sleep(2000);
        WebElement splitChildWindText  = driver.findElement(By.cssSelector("p[class='im-para red']"));
        Thread.sleep(2000);
        /*                         // splitting
        Please email us at --> mentor@rahulshettyacademy.com<-- with below template to receive response
         */
                    String getEmail = splitChildWindText.getText().split("at")[1].trim().split(" ")[0];

        System.out.println(getEmail +"  Aida u r the BEST "); // mentor@rahulshettyacademy.com

                    // NEXT Step is paste in parentWindow
        // to userNameBox this email from childWindow : mentor@rahulshettyacademy.com
        // switch to parent WondowId

     Thread.sleep(2000);
      driver.switchTo().window(parentId);
      driver.findElement(By.cssSelector("input[id='username']")).sendKeys(getEmail);

    }
}
