import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Practice20 {

    public static void main(String[] args) {

        //  Handling HTTPS certifications (PRIVACY ERROR )


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);  // for this kind of error with privacy error

        //  Explore Chrome options to set proxies,plugins & paths on Chrome browser
        // Proxy is like VPN less secure if use internet very often BUT has benefits too
        // We use Proxy Class when sometimes in companies u need proxy plugin to access to websites
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("download.default_directory", "/directory/path");

        options.setExperimentalOption("prefs", prefs);

        // handling an error on MsWord Browser
  //      EdgeOptions eoptions = new EdgeOptions();
   //     eoptions.setAcceptInsecureCerts(true);

        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());








    }
}
