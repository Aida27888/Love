package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.util.List;
import java.util.logging.XMLFormatter;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBox;

    @FindBy(xpath = "//a")
    List <WebElement> allLinks;

    @FindBy(id = "result-stats")
    WebElement result;


    @FindBy(xpath = "//nobr")
    WebElement resultOfPageTime;
     public void searchItem(String word){

       searchBox.sendKeys(word, Keys.ENTER);


   }

    public int numberOfLinks(){
       return allLinks.size();
}

       public int result (){
       String [] resultOfSearch = BrowserUtils.getText(result).split(" ");
       // About 360,000,000 results (0.61 seconds)
          return Integer.parseInt(resultOfSearch[1].replace(",", ""));
      }


public double timesResult(){

   //  (0.61 seconds)

    String[] time = BrowserUtils.getText(resultOfPageTime).split(" ");
      // return Double.parseDouble(BrowserUtils.getText(resultOfPageTime).substring(0,5));

    return Double.parseDouble(time[0].substring(1));
}

}