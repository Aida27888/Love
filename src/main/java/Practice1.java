import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice1 {


    public static void main(String[] args) {







                //Invoking Browser

                //Chrome - ChromeDriver exten->Methods close get

                //Firefox- FirefoxDriver ->methods close get

                // WebDriver  close  get

                //WebDriver methods + class methods


                // Chrome

                //   System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");


                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriver driver2 = new ChromeDriver(options);

                //Firefox


                //     System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver");

                //     WebDriver driver1 = new FirefoxDriver();


                //Microsoft Edge

//            System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");

                //   WebDriver driver2 = new EdgeDriver();


                driver2.get("https://rahulshettyacademy.com/");

                System.out.println(driver2.getTitle());

                System.out.println(driver2.getCurrentUrl());

             //   driver2.close();

                driver2.quit();








        }

    }






