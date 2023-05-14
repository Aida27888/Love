package com.test.weborder.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.BreakIterator;

public class WebOrderLoginPage {


    public WebOrderLoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy (css = "#Email")
    WebElement username;

    @FindBy (css = "#Password" )
    WebElement password;

    @FindBy (xpath = "//button[.='Sign In']")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class='mt-2 alert alert-danger']")
    WebElement errorMessage;
    public void login(String username, String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        this.loginButton.click();



    }


    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }








}
