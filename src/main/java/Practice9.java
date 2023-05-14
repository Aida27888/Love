import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Practice9 {


    public static void main(String[] args) {
//  Handling Checkbox and getting the size of them with Selenium
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

      // Checking why the calendar looks like disabled BUT its not (
        // html attrubutes slightly changes when you click radio button)

        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());

        System.out.println( driver.findElement(By.id("Div1")).getAttribute("style")); // getting text whats changing

  WebElement radioButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"));
              radioButton.click();
        System.out.println( driver.findElement(By.id("Div1")).getAttribute("style"));
        WebElement secndClaendar = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
        secndClaendar.isEnabled();
        System.out.println(   driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());

//   1 is enabled-True
//   0.5 is Disabled-False
        // Validating the changing html attribute

        if( driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){ // 1 OR 0.5

            Assert.assertTrue(true);
            System.out.println("it is Enabled");
        }else {
           Assert.assertTrue(false); // forcing to fail test
        }



    }
}
