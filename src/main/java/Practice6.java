import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Practice6 {

             // TestNg is one of the Testing Frameworks
    // for here I utilize the only assertion method from TestNg

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //WebElements is singular and checks the first match
        // WebElements is plural so checks the entire section List of elements


      WebElement senCitizenDiscnt =  driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));

        System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']") ).isSelected()); // False

        // assertion --> validating for False
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']") ).isSelected());
              senCitizenDiscnt.click();
        System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']") ).isSelected()); // True
       // assertion --> validating  for True
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']") ).isSelected());


// check all checkBox selected or NOT
        List<WebElement> checkSizeAll = driver.findElements(By.cssSelector("div[id='discount-checkbox']"));
        checkSizeAll.size();
        System.out.println(checkSizeAll.size()+ " Aida");


      // dropdown with select tag
        // Creating object of a Class
        WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(dropDown);
        // AED
        select.selectByVisibleText("AED");
        System.out.println(select.getFirstSelectedOption().getText());
       // INR
        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
        // USD
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());

           // if we wanna click passenger '+' sign multiple time without hardcoding
        // then we can loop it w while or for loop


        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);



		   /*int i=1;

	while(i<5)

	{

		driver.findElement(By.id("hrefIncAdt")).click();//4 times

		i++;

	}*/

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 1 Adult

        for(int i=1;i<5;i++)

        { // here '+' sign clicks 4 times without hardcoding

            driver.findElement(By.id("hrefIncAdt")).click();  // 5 Adult

        }




        driver.findElement(By.id("btnclosepaxoption")).click();
        // Assertion we r validating means checking

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());


    }
}
