import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Practice8 {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // Handling autosuggestive dropdowns
       WebElement countrySelect = driver.findElement(By.xpath("//input[@id='autosuggest']"));
               countrySelect.sendKeys("ind");
               Thread.sleep(3000);
       List<WebElement> optionsList =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

       for ( WebElement opList: optionsList){

            if(opList.getText().equalsIgnoreCase("india")){
                opList.click();
                break;

            }

       }




    }
}
