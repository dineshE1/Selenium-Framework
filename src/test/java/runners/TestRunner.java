package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    // Location of feature files
    features = "src/main/resources/features",

    // Location of step definitions
    glue = {"stepdefinitions"},

    // Run only smoke tagged scenarios
    tags = "@regression",

    // Report plugins
    plugin = {
        "pretty",                    // Console output
        "html:reports/cucumber.html", // HTML report
        "json:reports/cucumber.json"  // JSON for CI/CD
    },

    // Show more details
    monochrome = true
)
public class TestRunner
    extends AbstractTestNGCucumberTests {
    // TestNG runs Cucumber from here!
}