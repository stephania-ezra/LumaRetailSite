package com.practisingDaily.screenshotTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public final Logger log = LogManager.getLogger(BaseTest.class);
    public WebDriver driver;
    public String screenshotsSubFolderName;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    Path extendedTestHtml = Paths.get("src", "test", "resources", "extended-test.html");

    @Parameters("browserName")
    @BeforeTest
    //public void setup(ITestContext context, @Optional("Chrome") String browserName) {
    public void setUp(ITestContext context, @Optional("chrome") String browserName) {
        switch (browserName.toLowerCase()) { //edge
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        log.info("Setting Context browserName {}", browserName);
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);

        Capabilities c = ((RemoteWebDriver) driver).getCapabilities();
        //String device = c.getBrowserName() + " " + c.getBrowserVersion();

        // if u want to get the browser version in whole number use substring concept

        String device = c.getBrowserName() + " " + c.getBrowserVersion().substring(0, c.getBrowserVersion().indexOf("."));
        String author = context.getCurrentXmlTest().getParameter("author");

        //context.getName() gives the test name
        extentTest = extentReports.createTest(context.getName(), "My first ExtentReport in TestNG");
        extentTest.assignAuthor(author);
        extentTest.assignDevice(device);
    }


    @BeforeSuite
    public void initializeExtentReports() {
        ExtentSparkReporter esr_all = new ExtentSparkReporter(extendedTestHtml.toFile());

        extentReports = new ExtentReports();
        extentReports.attachReporter(esr_all);

        //system related information
        extentReports.setSystemInfo("OS Version",System.getProperty("os.version"));
        extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
    }

    @AfterSuite
    public void generateExtentReports() throws IOException {
        extentReports.flush();
        driver.quit();
        Desktop.getDesktop().browse(extendedTestHtml.toUri());
    }


    //Another method for capturing failed screenshots
    // dependency Injection - ITestResult object
    @AfterMethod
    public void screenshotCapture(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotFile = captureScreenShots(result.getTestContext().getName() + "_"
                    + result.getMethod().getMethodName() + ".jpg");
            extentTest.addScreenCaptureFromPath(screenshotFile, result.getTestName());
        }
    }

    String captureScreenShots(String fileName) {
        if (screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+screenshotsSubFolderName+"/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Screenshot saved successfully");
        return destFile.getAbsolutePath();
    }


    public void checkStatus(Method m , ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE ){
            String screenshotPath;
            screenshotPath = captureScreenShots(result.getTestContext().getName()
                    + "_" + result.getMethod().getMethodName() + ".jpg");
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass(m.getName() + " is passed ");
        }
        // m.getAnnotation(Test.class).groups()
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());
    }
}
