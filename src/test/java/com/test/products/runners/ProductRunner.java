package com.test.products.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features ="src/test/resources/features/products",
            glue = "com/test/products/stepdefinitions",
            dryRun = true,
            tags = "@regression",
            plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}

    )

    public class ProductRunner {


}
