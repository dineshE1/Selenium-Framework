package stepdefinitions;

import Base.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends Baseclass {

    // Runs before each scenario
    @Before
    public void beforeScenario() {
        setup(); // launch browser
        System.out.println("Browser launched ✅");
    }

    // Runs after each scenario
    @After
    public void afterScenario(Scenario scenario) {

        // Screenshot on failure
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,
                "image/png", "Screenshot");
            System.out.println("Screenshot captured ✅");
        }

        closeBrowser(); // quit browser
        System.out.println("Browser closed ✅");
    }
}