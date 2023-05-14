package com.test.weborder.runner;



    /*
            These are interview questions:
            * Runner class is a way to run your all feature files from here.Regression, smoke etc..
            *@RunWith --> annotation comes from Junit and it executes the feature file steps.
            * @CucumberOptions--> is a special annotation that has some keywords
            --> Feature --> this is the location of our feature files (this one should be "CONTENT ROOT)
            --> glue --> this is the location of step definitions file. (this one should be "SOURCE ROOT
            --> dryRun --> This is a way to get snips (steps) without executing the whole steps from beginning.
            --> tags --> is a way to specialize your scenario for the specific purposes (regression, smoke etc ...)
            --> plugin --> is a way to integrate specific condition for the keyword. it is mostly used for REPORT CARD.
              */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/weborder",
        glue = "com/test/weborder/stepdifinitions",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}

)
 public class WebOrderRunner {



}
















