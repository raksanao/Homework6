package com.zerobanking.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue="com/zerobanking/step_definitions",
        dryRun=false,
        tags="@new_payee @smoke",

        plugin = {"html:target/default-cucumber-reports",
        "rerun:target/rerun.txt",
        "json:target/cucumber.json"
}

)


public class CukesRunner {


}
