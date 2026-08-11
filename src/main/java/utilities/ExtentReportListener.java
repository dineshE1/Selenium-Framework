package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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

    // When test FAILS
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL,
            "Test Failed ❌");
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