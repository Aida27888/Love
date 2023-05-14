//package com.mentoringwithahmet.automationexercise.stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.WebDriver;
//import utils.BrowserUtils;
//import utils.ConfigReader;
//import utils.DriverHelper;
//
//public class AutomationHooK {
//
//
//    WebDriver driver = DriverHelper.getDriver();
//
//
//    @Before
//    public void setup(){
//        driver.get(ConfigReader.readProperty("automationexcersiseurl"));
//
//
//    }
//
//
//
//
//    @After
//    public void tearDown(Scenario scenario){
//        BrowserUtils.getScreenShotForCucumber(driver, scenario );
////   driver.quit();
//    }
//
//
//
//
//}
