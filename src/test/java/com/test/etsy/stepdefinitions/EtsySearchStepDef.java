package com.test.etsy.stepdefinitions;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class EtsySearchStepDef {

WebDriver driver = DriverHelper.getDriver();
EtsyMainPage mainPage = new EtsyMainPage(driver);


    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }
    @When("User searches for {string} in Etsy Webpage")
    public void user_searches_for_in_etsy_webpage(String word) {
        mainPage.searchKey(word);
    }
    @Then("User validates the title {string} from Etsy")
    public void user_validates_the_title_from_etsy(String expextedTitle) {
        Assert.assertEquals(expextedTitle, driver.getTitle().trim());
    }









}
