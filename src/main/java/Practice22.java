import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Practice22 {


    public static void main(String[] args) throws IOException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("http://qaclickacademy.com/practice.php");

        //   Strategy to automate the broken Links with Selenium
        // broken URL

        //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

     //  String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

// Calling Java URL class

/*
       String brknLink =  driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
     HttpURLConnection conn2 = (HttpURLConnection) new URL(brknLink).openConnection();
        conn2.setRequestMethod("HEAD");
        conn2.connect();
       int respCode2 = conn2.getResponseCode();
        System.out.println(respCode2);  // 404
itel
 */

        //    Iterate over all links in the page to validate broken Links mechanism

List<WebElement > linksAll = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert sAssrt = new SoftAssert(); // declaring softAssert

        for (WebElement allLinks:linksAll) {
           String url = allLinks.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); // casted
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);  // 200
     //       using softAssert instead if-condition
            sAssrt.assertTrue(respCode < 400, "The link with Text " + allLinks.getText() +" is broken link " + respCode);

//            if(respCode > 400){
//                System.out.println("The link with Text " + allLinks.getText() +" is broken link " + respCode);
//                Assert.assertTrue(false);
//            }
        }

    sAssrt.assertAll();
    }
}
