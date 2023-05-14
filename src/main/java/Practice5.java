import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice5 {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);


    //    System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

         /*
                    GET
                    waits to load all components on page and NO Mehtods

                    NAVIGATE
                    doesn't wait till fully page load and HAS Methods (to(), back(), forward()  )
          */

        driver.manage().window().maximize();

        driver.get("http://google.com");

        driver.navigate().to("https://rahulshettyacademy.com");

        driver.navigate().back();

        driver.navigate().forward();

    }
}
