package com.test.weborder.stepdifinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderLoginStepDef {

   WebDriver driver = DriverHelper.getDriver();

WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);

    @Given("User navigates to WebOrderPage")
    public void user_navigates_to_web_order_page() {
        driver.get(ConfigReader.readProperty("weborderurl"));
    }
    @When("User provides username {string} and password {string} for WebOrder")
    public void user_provides_username_and_password_for_web_order(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("User validates the title {string} from homepage")
    public void user_validates_the_title_from_homepage(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        driver.quit();
    }
    @Then("User validates the error message {string}")
    public void user_validates_the_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,loginPage.validateErrorMessage());
    }



}





