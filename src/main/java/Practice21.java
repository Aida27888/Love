import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Practice21 {

// Maximizing window and deleting cookies
    public static void main(String[] args) throws IOException {

/*
What Are Cookies?
Cookies are text files with small pieces of data — like
a username and password — that are used to identify your computer as you
 use a computer network. Specific cookies known as HTTP cookies are used to
 identify specific users and improve your web browsing experience.

Data stored in a cookie is created by the server upon your connection.
 This data is labeled with an ID unique to you and your computer.

When the cookie is exchanged between your computer and the network server,
the server reads the ID and knows what information to specifically serve to you.

 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().window().maximize(); // maximize the window before it starts testing the code
        // and if u wanna delete all the cookies before testing the code
        driver.manage().deleteAllCookies(); // deletes all cookies
     //  driver.manage().deleteCookieNamed("sessionKey"); // delete one cookie only by name

        // click on any link
        // login page , verify login url
        driver.get("https://www.google.com/");

        //  How to take Screenshots in Selenium


       File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrShot, new File("/Users/arakhimzhanova/Desktop/screenshot.png"));


    }
}
