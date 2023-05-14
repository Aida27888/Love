import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class E2E {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");



        WebElement oneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
        oneWay.click();
        Thread.sleep(1000);

        WebElement depatBox =    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        depatBox.click();
        Thread.sleep(1000);

        WebElement depatCity =    driver.findElement(By.xpath("//a[@value='DEL']"));
        depatCity.click();
        Thread.sleep(1000);

        WebElement arricvlCity =   driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"));
        arricvlCity.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date1']")).click();
        Thread.sleep(2000);
       // todays date gives me error bcz default on dash is Mayyyy
        WebElement todaysDate =   driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active']"));
        todaysDate.click();
        Thread.sleep(2000);


        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

        {



            System.out.println("its disabled");

            Assert.assertTrue(true);



        }

        else

        {

            Assert.assertTrue(false);

        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();



        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);

        for(int i=1;i<5;i++)

        {

            driver.findElement(By.id("hrefIncAdt")).click();

        }



        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());





        //	driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

        driver.findElement(By.cssSelector("input[value='Search']")).click();

        //	driver.findElement(By.xpath("//input[@value='Search']")).click();

        //	driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();






    }
}
