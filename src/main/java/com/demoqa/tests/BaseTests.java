package com.demoqa.tests;

import com.aventstack.extentreports.Status;
import com.demoqa.pages.ElementsPage;
import commonImplementations.CommonDrivers;
import commonImplementations.utils.ConfigReaderUtil;
import commonImplementations.utils.ReportsUtils;
import commonImplementations.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTests {

    String currentDir;
    String configFileDir;
    Properties configProperties;
    String Baseurl;
    String browserType;

    ElementsPage elementsPage;

    CommonDrivers commonDrivers;
    WebDriver driver;

    ScreenshotUtils screenshotUtils;
    String reportFilename;
    ReportsUtils reportsUtils;


    @BeforeSuite
    public void preSetup() throws Exception{
        currentDir = System.getProperty("user.dir");
        configFileDir = currentDir+"/configProperties/config.properties";
        reportFilename = currentDir+"/reports/demoqaTestReport.html";
        configProperties = ConfigReaderUtil.readConfigProperties(configFileDir);
        reportsUtils = new ReportsUtils(reportFilename);
    }

    @BeforeClass
    public void setup() throws Exception
    {
        Baseurl = configProperties.getProperty("url");
        browserType = configProperties.getProperty("browserType");
        commonDrivers = new CommonDrivers(browserType);
        driver = commonDrivers.getDriver();
        elementsPage = new ElementsPage(driver);
        commonDrivers.navigatetoURL(Baseurl);
        screenshotUtils = new ScreenshotUtils(driver);
    }

    @AfterMethod
    public void postTestAction(ITestResult iTestResult) throws Exception {
        String testCaseName = iTestResult.getName();
        long executionTime = System.currentTimeMillis();
        String screenshotFileName = currentDir+"/reports/"+ testCaseName + executionTime +".jpeg";
        String screenshotName = testCaseName + executionTime +".jpeg";


        if(iTestResult.getStatus() == iTestResult.FAILURE)
        {
            reportsUtils.addTestLog(Status.FAIL, "one or more testcase failed");
            screenshotUtils.saveScreenshot(screenshotFileName);
        }
        screenshotUtils.saveScreenshot(screenshotFileName);
        reportsUtils.attachScreenshotToReport(screenshotName);
    }

    @AfterClass
    public void tearDown()
    {
        commonDrivers.closeAllBrowser();
    }

    @AfterSuite
    public void postTearDown()
    {
        reportsUtils.flushReport();
    }

}
