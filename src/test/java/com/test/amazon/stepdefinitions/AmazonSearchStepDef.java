package com.test.amazon.stepdefinitions;

import com.test.amazon.pages.AmazonMainPaige;
import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AmazonSearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
   AmazonMainPaige amazonMainPaige = new AmazonMainPaige(driver);




@Given("User navigates to the Amazon")
public void user_navigates_to_the_amazon() {
    driver.get(ConfigReader.readProperty("amazonurl"));
}
    @When("User searches for {string} on Amazon")
    public void user_searches_for_on_amazon(String expectedWord) {
        amazonMainPaige.searchItem(expectedWord);
    }
    @Then("User validates the result contains {int}")
    public void user_validates_the_result_contains(int expectedNumber) {
        Assert.assertTrue(amazonMainPaige.resultNumber(expectedNumber));
    }
    @Then("User validates all header contains {string}")
    public void user_validates_all_header_contains(String expectedKey) {
        amazonMainPaige.validateAllHeaders(expectedKey);
    }






}






