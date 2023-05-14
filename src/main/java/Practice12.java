import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Practice12 {
    public static void main(String[] args) throws InterruptedException {
/*                 SYNTAX ExplicitWait
            //WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
            WebDriverWait wait = new WebDriverWait (driver, 20);
            wait.until(ExpectedConditions.VisibilityofElementLocated(By.xpath(""//button[@value='Save Changes']"")));
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Implicit wait


        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));  // Explicit wait
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));  // continues
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // again on new element
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1 Kg

            //Brocolli,    1 kg
            // Splitting at hyphen and getting [0] index which is the name of vegetables
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

           //format it to get actual vegetable name
            //convert array into array list for easy search
            //  check whether name you extracted is present in arrayList or not-
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }

            /*
                The following are the Expected Conditions that can be used in Explicit Wait

                alertIsPresent()
                elementSelectionStateToBe()
                elementToBeClickable()
                elementToBeSelected()
                frameToBeAvaliableAndSwitchToIt()
                invisibilityOfTheElementLocated()
                invisibilityOfElementWithText()
                presenceOfAllElementsLocatedBy()
                presenceOfElementLocated()
                textToBePresentInElement()
                textToBePresentInElementLocated()
                textToBePresentInElementValue()
                titleIs()
                titleContains()
                visibilityOf()
                visibilityOfAllElements()
                visibilityOfAllElementsLocatedBy()
                visibilityOfElementLocated()
                 */
        }

    }
}
