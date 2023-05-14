package com.test.weborder.stepdifinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WebOrderOrderPage;
import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);

    WebOrderOrderPage orderOrderPage = new WebOrderOrderPage(driver);
    @Given("User navigates to the WebOrder Page and login successfully")
    public void user_navigates_to_the_web_order_page_and_login_successfully() {
        loginPage.login(ConfigReader.readProperty("weborderusername"), ConfigReader.readProperty("weborderpassword"));
    }

    @Given("User validates the title {string} from order page")
    public void user_validates_the_title_from_order_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    @When("User on Order Page clicks Group Order box and Next button")
    public void user_on_order_page_clicks_group_order_box_and_next_button() {
     orderOrderPage.clickGroupOrderBox();
     orderOrderPage.clickNextButton();
    }

    @Then("User sends the word {string} for Note to Invitees part")
    public void user_sends_the_word_for_note_to_invitees_part(String note) {
     orderOrderPage.sendingNotes(note);
    }

    @Then("User sends email which are {string} and {string} for Invite List")
    public void user_sends_email_which_are_and_for_invite_list(String email_1, String email_2) {
   orderOrderPage.sendingInviteList(email_1, email_2);
    }

    @Then("User choose the delivery address {string} and validate the address {string}")
    public void user_choose_the_delivery_address_and_validate_the_address(String option, String expectedAddress) throws InterruptedException {
        Thread.sleep(3000);
    orderOrderPage.chooseDeliveryOption(option, expectedAddress);
    }

    @Then("User clicks the create Group Order button")
    public void user_clicks_the_create_group_order_button() {
    orderOrderPage.clickOrderButton();
    }

    @Then("User validates the header of page is {string}")
    public void user_validates_the_header_of_page_is(String expectedHeader) throws InterruptedException {
        Thread.sleep(3000);
    Assert.assertTrue(orderOrderPage.validateHeader(expectedHeader));

    }







}