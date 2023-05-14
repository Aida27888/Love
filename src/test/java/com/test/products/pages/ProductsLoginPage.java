package com.test.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsLoginPage {

    public ProductsLoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
   /*
     @FindBy("")
    WebElement ;
    */



    @FindBy(css = "#ctl00_MainContent_username")
    WebElement username;


    @FindBy(css = "#ctl00_MainContent_password")
    WebElement password;

    @FindBy(css = "#ctl00_MainContent_login_button")
    WebElement loginButton;



    public void LogIn(String userName, String passWord){

        this.username.sendKeys(userName);
        this.password.sendKeys(passWord);
        this.loginButton.click();


    }




}
