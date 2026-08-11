package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports extentReports;

    public static ExtentReports getInstance() {

        if (extentReports == null) {

            // Report file location
            ExtentSparkReporter reporter =
                new ExtentSparkReporter(
                    "reports/TestReport.html");

            // Report configuration
            reporter.config().setReportName(
                "SauceDemo Automation Report");
            reporter.config().setDocumentTitle(
                "E2E Test Results");
            reporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);

            // System info shown in report
            extentReports.setSystemInfo(
                "Tester", "Dinesh E");
            extentReports.setSystemInfo(
                "Application", "SauceDemo");
            extentReports.setSystemInfo(
                "Environment", "QA");
            extentReports.setSystemInfo(
                "Browser", ConfigReader.get("browser"));
        }

        return extentReports;
    }
}