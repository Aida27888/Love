package com.test.products.pages;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsOrderPage {

    public ProductsOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }


    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement name;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipcode;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americaExpressCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement cardExpireDate;


    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//strong")
    WebElement pageMessage;


    @FindBy(xpath = "//td//tr//td")
    List<WebElement> listInfo;


//    @FindBy(xpath = "//a[.='View all orders']")
//    WebElement viewAllOrderButton;


    @FindBy(css = "#ctl00_MainContent_orderGrid_ctl02_OrderSelector")
    WebElement checkBox;


    public void sendProductInformation(String productName, String quantity){

        BrowserUtils.selectBy(product, productName, "text");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);

    }


    public void sendAddressInformation(String name, String street, String city, String zip  ){

        this.name.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zip);

    }

    public void sendPaymentInformation(String cardType, String cardNumb, String expDate  ) throws InterruptedException {
        selectPaymentCard(cardType);
        Thread.sleep(1000);
        this.cardNumber.sendKeys(cardNumb);
        this.cardExpireDate.sendKeys(expDate);
        this.processButton.click();
        Thread.sleep(3000);

    }


    public void selectPaymentCard(String cardType) throws InterruptedException {

        cardType = cardType;
        switch (cardType){
            case "Visa":
                Thread.sleep(1000);
                visaCard.click();
                break;

            case "MasterCard":
                Thread.sleep(1000);
                masterCard.click();
                break;

            case "American Express":
                Thread.sleep(1000);
                americaExpressCard.click();
                break;

            default:
                System.out.println("Card Type is incorrect, please check it");
        }


    }



    public String validateMessage() throws InterruptedException {
        Thread.sleep(2000);
        return  BrowserUtils.getText(pageMessage);
    }



//    public List<String> actualLisst() throws InterruptedException {
//
//
//
//        List<String>actualList= new ArrayList<>();
//
//        Thread.sleep(3000);
//
//        for (int i = 1; i < 13-1; i++){
//
//            Thread.sleep(1000);
//            actualList.add(listInfo.get(i).getText().trim());
//        }
//        return actualList;
//
//    }
}
