package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue="com/zerobank/stepdefinitions",
        features = "src/test/resources",
        dryRun = false,
        strict = true,
        tags = "@login_with_wrong_info",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }
)

public class CukesRunner {
}
