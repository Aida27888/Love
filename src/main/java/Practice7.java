import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice7 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Handling dynamic dropDowns & Calendar

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        Thread.sleep(3000L);
      //  driver.findElement(By.xpath("//a[@value='BLR']")).click();

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).getText());
    //    Thread.sleep(5000L);

    //    driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

     //   Thread.sleep(3000L);

    //    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).getText());

        Thread.sleep(1000L);
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-current-day.ui-datepicker-today")).click();



        //  1st way to handle dynamic dropdown box is PARENT-CHILD

        //-->Parent //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] -->child//a[@value='BLR']


     //  some companies don't like this index way       (      //a[@value='MAA']    )   [2]
        // here above we handle dynamic element with '( wrap in parentheses )' AND '[any number of same element ]' indexes




    }
}
