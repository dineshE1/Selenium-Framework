package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.Baseclass;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extentReports
        = ExtentReportManager.getInstance();

    // ThreadLocal for parallel test support
    private static ThreadLocal<ExtentTest> extentTest
        = new ThreadLocal<>();

    // When test STARTS
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(
            result.getMethod().getMethodName());
        extentTest.set(test);
        test.log(Status.INFO,
            "Test Started: "
            + result.getMethod().getMethodName());
    }

    // When test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,
            "Test Passed ✅");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod()
            .getMethodName();

        // ✅ Get test instance
        Object testInstance = result.getInstance();

        // ✅ Check if instance is Baseclass
        if (testInstance instanceof Baseclass) {

            Baseclass baseclass = (Baseclass) testInstance;

            // ✅ NULL CHECK — only screenshot if driver exists!
            if (baseclass.driver != null) {
                String screenshotPath = ScreenshotUtility
                    .takeScreenshot(
                        baseclass.driver, testName);

                try {
                    extentTest.get().fail(
                        "Test Failed ❌",
                        MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                screenshotPath).build());
                } catch (Exception e) {
                    extentTest.get().log(
                        Status.FAIL, "Test Failed ❌");
                }
            } else {
                // Driver is null — just log failure
                extentTest.get().log(Status.FAIL,
                    "Test Failed ❌ (Driver was null — " +
                    "browser setup may have failed)");
            }
        }

        // Always log the error
        extentTest.get().log(Status.FAIL,
            result.getThrowable());
    }

    // When test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP,
            "Test Skipped ⚠️");
    }

    // When ALL tests finish — flush report
    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        System.out.println(
            "Report generated: reports/TestReport.html ✅");
    }
}