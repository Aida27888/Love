package com.test.products.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductViewOrderPage {  //     Aida IT IS a SECOND PAGE Just reDO iT  -->
                                                                                  // APACHE PUI ????

    public ProductViewOrderPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allData;



    public void  validationInformation(String name, String product, String quantity, String street, String city,
                                       String zip, String card, String cardnumber, String expdate) throws InterruptedException {


//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyy");
//       String currentDate = simpleDateFormat.format(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

List<String> expectValues = Arrays.asList( "", name,  product,  quantity, currentTime,  street,  city, "", zip,  card,  cardnumber,  expdate);


for(int i = 1;  i < allData.size()-1; i++ ){
Thread.sleep(3000);
    Assert.assertEquals(expectValues.get(i), BrowserUtils.getText(allData.get(i)));

}



    }







}
