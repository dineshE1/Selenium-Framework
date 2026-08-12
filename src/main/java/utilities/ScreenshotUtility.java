package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String takeScreenshot(
            WebDriver driver, String testName) {

        // Timestamp for unique filename
        String timestamp = new SimpleDateFormat(
            "yyyyMMdd_HHmmss").format(new Date());

        // Screenshot file path
        String screenshotPath = "screenshots/"
            + testName + "_" + timestamp + ".png";

        try {
            // Take screenshot
            File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

            // Save to screenshots folder
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved: "
                + screenshotPath + " ✅");

        } catch (IOException e) {
            System.out.println(
                "Screenshot failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}