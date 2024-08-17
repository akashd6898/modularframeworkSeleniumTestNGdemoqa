package commonImplementations.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsUtils {

    ExtentSparkReporter htmlReport;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ReportsUtils(String htmlReportFileName)
    {
        htmlReportFileName = htmlReportFileName.trim();
        htmlReport = new ExtentSparkReporter(htmlReportFileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReport);
    }
    public void createTestCase(String testcaseName)
    {
        extentTest = extentReports.createTest(testcaseName);
    }
    public void addTestLog(Status status, String comment)
    {
        extentTest.log(status, comment);
    }
    public void attachScreenshotToReport(String fileName)
    {
        extentTest.addScreenCaptureFromPath(fileName);
    }
    public void flushReport()
    {
        extentReports.flush();
    }
}
