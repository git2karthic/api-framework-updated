package bdd.cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/bdd/cucumber/features",
        plugin ="json:target/jsonReports/cucumber-report.json",
        glue = {"bdd.cucumber.stepDefinitions"})
public class TestRunner {
}
