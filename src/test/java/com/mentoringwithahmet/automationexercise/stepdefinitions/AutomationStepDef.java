package com.mentoringwithahmet.automationexercise.stepdefinitions;

import com.mentoringwithahmet.automationexercise.pages.AutomationLoginPage;
import com.mentoringwithahmet.automationexercise.pages.AutomationMainPage;
import com.mentoringwithahmet.automationexercise.pages.AutomationSignUpPage;
import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class AutomationStepDef {


  WebDriver driver = DriverHelper.getDriver();
  AutomationMainPage mainPage = new AutomationMainPage(driver);
  AutomationSignUpPage signUpPage = new AutomationSignUpPage(driver);

  AutomationLoginPage loginPage = new AutomationLoginPage(driver);



    @Given("User navigates to the automationExercise WebPage and validates the {string}")
    public void user_navigates_to_the_automation_exercise_web_page_and_validates_the(String expectTittle) throws InterruptedException {

        driver.get(ConfigReader.readProperty("automationexcersiseurl"));
        Thread.sleep(500);
        Assert.assertEquals(expectTittle, driver.getTitle().trim());
    }
    @When("User clicks signUp button and validates the {string} visible")
    public void user_clicks_sign_up_button_and_validates_the_visible(String expectedNewSignupHeader) throws InterruptedException {
        signUpPage.clicksSignUp();
        Thread.sleep(500);
        Assert.assertTrue(signUpPage.validateNewSignUpHeader(expectedNewSignupHeader));

    }
    @When("User provides username {string} and email address {string} and click sign up button")
    public void user_provides_username_and_email_address_and_click_sign_up_button(String username, String email) throws InterruptedException {
        Thread.sleep(500);
     signUpPage.login(username, email);
    }
    @When("User verify  {string} message is visible")
    public void user_verify_message_is_visible(String expectedAccountTitle) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(loginPage.headerLoginPage(expectedAccountTitle));
    }
    @When("User provides Title, Name, Email, Password {string}, Date of birth {string}, {string}, {string}")
    public void user_provides_title_name_email_password_date_of_birth(String password, String day, String month, String year) {

     loginPage.validatePasswordAndDofB(ConfigReader.readProperty("automationpassword"), ConfigReader.readProperty("automationdayofbirth"),
             ConfigReader.readProperty("automationmonthofbirth"), ConfigReader.readProperty("automationdyearofbirth"));

    }
    @When("User selects Sign up for our newsletter! and Receive Special offers from our partners!")
    public void user_selects_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners() {
        loginPage.newsLetterBox();
        loginPage.recieveOffers();
    }
    @When("User provides {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_provides(String fName, String lName, String compani, String adres1, String adres2,
                              String optionUsa, String statE, String citY, String zipcode, String phoneNumb){

        loginPage.validateAccountInfo(fName, lName, compani, adres1, adres2, optionUsa, statE, citY, zipcode, phoneNumb );
    }
    @Then("User clicks Create Account button and validates {string}")
    public void user_clicks_create_account_button_and_validates(String expectedHeader) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(loginPage.validateHeaderCreatedAccount(driver, expectedHeader));
    }
    @Then("User clicks Continue button and validates {string}")
    public void user_clicks_continue_button_and_validates(String expectedLoginProve) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(loginPage.validateContinueAndLoginMessage(driver, expectedLoginProve));
    }
    @Then("User clicks Delete Account button and validates {string} is visible")
    public void user_clicks_delete_account_button_and_validates_is_visible(  String expectedDeletedMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.validateDeletedAccountMessage( driver, expectedDeletedMessage));
    }
    @Then("User clicks continue button")
    public void user_clicks_continue_button() {
        loginPage.continueDeletedPageButton();
    }


}
