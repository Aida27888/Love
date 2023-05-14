package com.test.weborder.pages;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WebOrderOrderPage {

    public WebOrderOrderPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }
    /*

    # Navigate to the website and login successfully
#Validate the ORDER DETAILS from order page
#Click Group Order box and Click Next button
#Send the word for Note to Invitees part
#send two gmail for Invite List
  #Choose my location is My House
#Validate the adress contains 1854 Empire Blvd
#Click Create Group Order
#Vlick Create Group Order
     */

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    @FindBy( id = "InviteNote")
    WebElement InviteNote;

    @FindBy( id = "InviteList")
    WebElement inviteList ;

    @FindBy( xpath = "//select[@id='ConfirmAddressID']")
    WebElement location;

    @FindBy( id = "addressPreview")
    WebElement address;

    @FindBy( id = "createGroupOrder")
    WebElement cretaeGroupOrderButton;

    @FindBy( tagName = "h1")
    WebElement header;



    public void clickGroupOrderBox(){
        groupOrderBox.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }


    public void chooseDeliveryOption(String option, String expectedAddress) throws InterruptedException {

        BrowserUtils.selectBy(location, option, "text");
        Thread.sleep(3000);
        Assert.assertTrue( BrowserUtils.getText(address).contains(expectedAddress));
    }

    public void sendingNotes(String invitenote){
        this.InviteNote.sendKeys(invitenote);
    }

    public void sendingInviteList(String email1, String email2){
        inviteList.sendKeys(email1 + ", " + email2 );
    }

    public void clickOrderButton(){
        cretaeGroupOrderButton.click();
    }

    public boolean validateHeader(String expectedHeader) throws InterruptedException {
Thread.sleep(3000);
        return  BrowserUtils.getText(header).equals(expectedHeader);


    }





}
