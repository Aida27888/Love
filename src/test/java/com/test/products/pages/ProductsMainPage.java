package com.test.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsMainPage {


    public ProductsMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }



    @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;



    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrderClick;

    public void clickOrderButton(){
        this.orderButton.click();
    }



    public void clickViewOrderPage(){
        this.viewAllOrderClick.click();
    }



}

