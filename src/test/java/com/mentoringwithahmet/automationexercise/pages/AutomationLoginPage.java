package com.mentoringwithahmet.automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationLoginPage {

public AutomationLoginPage(WebDriver driver){

    PageFactory.initElements(driver, this);
}


    @FindBy( xpath = "//b[.='Enter Account Information']")
    WebElement headerLoginPage;

    @FindBy( xpath = "//input[@id='id_gender2']")
    WebElement clickFemaleButton;



    @FindBy( xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(id = "days")
    WebElement chooseDay;

    @FindBy( id = "months")
    WebElement ChooseMonth;

    @FindBy( id = "years")
    WebElement chooseYear;

    @FindBy( xpath = "//label[@for='newsletter']")
    WebElement newsLetterBox;

     @FindBy( xpath = "//label[@for='optin']")
     WebElement recieveOffers;


    @FindBy( xpath = "//input[@id='first_name']")
    WebElement firstName;

    @FindBy( xpath = "//input[@id='last_name']")
    WebElement lastName;

    @FindBy( xpath = "//input[@id='company']")
    WebElement company;

    @FindBy( xpath = "//input[@id='address1']")
    WebElement address1;

    @FindBy( xpath = "//input[@id='address2']")
    WebElement address2;   //

    @FindBy( xpath = "//select[@id='country']")
    WebElement country;

    @FindBy( xpath = "//input[@id ='state']")
    WebElement state;

    @FindBy( xpath = "//input[@id ='city']")
    WebElement city;

    @FindBy( xpath = "//input[@id ='zipcode']")
    WebElement zipCode;

    @FindBy( xpath = "//input[@id ='mobile_number']")
    WebElement phoneNumber;

    @FindBy( xpath = "//button[.='Create Account']")
    WebElement createButton;



    @FindBy( xpath = "//b[.='Account Created!']")
    WebElement accountCreatedMessage;



    @FindBy( xpath = "//a[.='Continue']")
    WebElement continueButton;


    @FindBy( xpath = "//a//i[@class='fa fa-user']")
    WebElement logInProveMessage;



    @FindBy( xpath = "//ul//li//a[.=' Delete Account']")
    WebElement deleteButton;

    @FindBy( xpath = "//b[.='Account Deleted!']")
    WebElement deletedMessage;


      @FindBy( xpath = "//a[@data-qa='continue-button']")
      WebElement continueDeletedPageButton;




    @FindBy( xpath = "//option[@value='27']")
    WebElement daySelect;

    @FindBy( xpath = "//option[@value='2']")
    WebElement monthSelect;

    @FindBy( xpath = "//option[@value='1988']")
    WebElement yearSelect;







    public boolean headerLoginPage( String expectedLoginPageHeader) throws InterruptedException {

        return BrowserUtils.getText(headerLoginPage).equals(expectedLoginPageHeader);
    }





 public void validatePasswordAndDofB( String password, String day, String month, String year ){
        this.clickFemaleButton.click();
        this.passwordBox.clear();
        this.passwordBox.sendKeys(password);

        this.chooseDay.click();
        BrowserUtils.selectBy(chooseDay, day, "value");
        this.ChooseMonth.click();
        BrowserUtils.selectBy(ChooseMonth, month, "text");
        this.chooseYear.click();
        BrowserUtils.selectBy(chooseYear, year, "value");

 }


public void newsLetterBox(){
        this.newsLetterBox.click();
}

public void recieveOffers(){
        this.recieveOffers.click();
}



  public void validateAccountInfo(String fName, String lName, String compani, String adres1, String adres2,
                                 String optionUsa, String statE, String citY, String zipcode, String phoneNumb ){

        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.company.sendKeys(compani);
        this.address1.sendKeys(adres1);
        this.address2.sendKeys(adres2);
        this.country.click();
        BrowserUtils.selectBy(country, optionUsa, "text" );
        this.state.sendKeys(statE);
        this.city.sendKeys(citY);
        this.zipCode.sendKeys(zipcode);
        this.phoneNumber.sendKeys(phoneNumb);


  }


  public boolean validateHeaderCreatedAccount( WebDriver driver, String expectedHeader) throws InterruptedException {
      this.createButton.click();

      Thread.sleep(500);
      return BrowserUtils.getText(accountCreatedMessage).equals(expectedHeader);


  }


    public boolean validateContinueAndLoginMessage(WebDriver driver, String expectedLogInProve) throws InterruptedException {

        this.continueButton.click();
        driver.navigate().refresh();
        this.continueButton.click();
        Thread.sleep(6000);
       Actions actions = new Actions(driver);
        Thread.sleep(6000);
        actions.moveToElement(logInProveMessage).click().perform();
        return BrowserUtils.getText(logInProveMessage).equals(expectedLogInProve);


    }


       public boolean validateDeletedAccountMessage( WebDriver driver, String expectedDeletedMessage) throws InterruptedException {
           this.deleteButton.click();
        driver.navigate().refresh();
        Thread.sleep(5000);
        this.deleteButton.click();
        return BrowserUtils.getText(deletedMessage).equals(expectedDeletedMessage);
       }

       public void continueDeletedPageButton(){

        this.continueDeletedPageButton.click();
       }
}
