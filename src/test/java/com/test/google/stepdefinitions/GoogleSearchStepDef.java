package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class GoogleSearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);


    @Given("User navigates to the Google")
    public void user_navigates_to_the_google() {

        driver.get(ConfigReader.readProperty("googleurl"));

    }

    @When("User searches for  Techtorial")
    public void user_searches_for_techtorial() {
        googleMainPage.searchItem("Techtorial");

    }


    @Then("User gets more than ten links on the google page.")
    public void user_gets_more_than_ten_links_on_the_google_page() {

        Assert.assertTrue(googleMainPage.numberOfLinks() > 10);

    }

    @When("User searches for {string}")
    public void user_searches_for(String word) {
        googleMainPage.searchItem(word);

    }

    @Then("User validates the result is more than {int}")

    public void user_validates_the_result_is_more_than(Integer result) {
        System.out.println(googleMainPage.result());
        Assert.assertTrue(googleMainPage.result() > result);

    }





    @Then("User validates the loading time is less than {double} second")
    public void user_validates_the_loading_time_is_less_than_second(Double expectedOfSeconds) {

        System.out.println(googleMainPage.timesResult());

       Assert.assertTrue(googleMainPage.timesResult() < expectedOfSeconds);
    }

}
