package com.test.products.stepdefinitions;

import com.test.products.pages.ProductViewOrderPage;
import com.test.products.pages.ProductsLoginPage;
import com.test.products.pages.ProductsMainPage;
import com.test.products.pages.ProductsOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductCreationStepDef {

  WebDriver driver = DriverHelper.getDriver();

  ProductsLoginPage productsLoginPage = new ProductsLoginPage(driver);
  ProductsMainPage mainPage = new ProductsMainPage(driver);

  ProductsOrderPage productsOrderPage = new ProductsOrderPage(driver);

  ProductViewOrderPage productViewOrderPage = new ProductViewOrderPage(driver);


  @Given("User navigates to product homepage and click order Button")
  public void user_navigates_to_product_homepage_and_click_order_button() {
    productsLoginPage.LogIn(ConfigReader.readProperty("productusername"), ConfigReader.readProperty("productpassword"));
    mainPage.clickOrderButton();
  }

  @When("User enters the product information {string} and {string}")
  public void user_enters_the_product_information_and(String productName, String quantity) {
    productsOrderPage.sendProductInformation(productName, quantity);
  }


  @When("User enters the payment information {string}, {string}, {string} and click process button")
  public void user_enters_the_payment_information_and_click_process_button(String cardType, String cardNumber, String expDate) throws InterruptedException {
    productsOrderPage.sendPaymentInformation(cardType, cardNumber, expDate);
  }

  @Then("User validates the message {string}")
  public void user_validates_the_message(String expectedMessage) throws InterruptedException {
    Assert.assertEquals("New order has been successfully added.", productsOrderPage.validateMessage());
  }


  @And("User enters the address information {string},{string},{string},{string}")
  public void user_enters_the_address_information(String name, String street, String city, String zipcode) {
    productsOrderPage.sendAddressInformation(name, street, city, zipcode);
  }



//
//  @Then("User clicks view All orders button and validates {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//  public void user_clicks_view_all_orders_button_and_validates(String name, String product, String quantity, String date, String street, String city, String state,
//                                                               String zip, String card, String cardnumber, String expdate) throws InterruptedException {
//    List<String> expectedList = Arrays.asList(name, product, quantity, date, street, city, state, zip, card, cardnumber, expdate);// comes from feature
//    Assert.assertEquals(expectedList, productsOrderPage.actualLisst());
//  }

  @Then("User clicks view All orders button and validates {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
  public void user_clicks_view_all_orders_button_and_validates(String name, String product, String quantity, String street, String city,
                                                               String zip, String card, String cardnumber, String expdate) throws InterruptedException {

    mainPage.clickViewOrderPage();
    productViewOrderPage.validationInformation( name,  product,  quantity,  street,  city,
             zip,  card,  cardnumber,  expdate);


  }
//------------------------------------------------------------------------------------------
  @When("User enters the product information product and quantity")
  public void user_enters_the_product_information_product_and_quantity(DataTable dataTable) {
   Map<String, String> productInformation = dataTable.asMap();
   productsOrderPage.sendProductInformation(productInformation.get("product"), productInformation.get("quantity"));
  }
  @When("User enters the address information name, street, city, zip")
  public void user_enters_the_address_information_name_street_city_zip(DataTable dataTable) {
   Map <String, String> addressInformation = dataTable.asMap();
   productsOrderPage.sendAddressInformation(addressInformation.get("name"), addressInformation.get("street"), addressInformation.get("city"), addressInformation.get("zip"));
  }
  @When("User enters the payment information cardType, ardNumber, expireDate and click process button")
  public void user_enters_the_payment_information_card_type_ard_number_expire_date_and_click_process_button(DataTable dataTable) throws InterruptedException {
  Map <String, String> paymentInformation = dataTable.asMap();
  productsOrderPage.sendPaymentInformation(paymentInformation.get("cardType"), paymentInformation.get("cardNumber"), paymentInformation.get("expireDate"));
  }
  @Then("User validates the message message")
  public void user_validates_the_message_message(DataTable dataTable) throws InterruptedException {
   List <String > expectedMessage = dataTable.asList();
   Assert.assertEquals(expectedMessage.get(0), productsOrderPage.validateMessage());


  }


}