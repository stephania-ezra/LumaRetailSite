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
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public static WebDriver driver;
    public static String screenshotsSubFolderName;
    public static ExtentReports er;
    public static ExtentTest et;
    public static Logger log = LogManager.getLogger(BaseTest.class);

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
        log.info("Setting Context");
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);

        Capabilities c = ((RemoteWebDriver) driver).getCapabilities();
        //String device = c.getBrowserName() + " " + c.getBrowserVersion();

        // if u want to get the browser version in whole number use substring concept

        String device = c.getBrowserName() + " " + c.getBrowserVersion().substring(0, c.getBrowserVersion().indexOf("."));
        String author = context.getCurrentXmlTest().getParameter("author");

        //context.getName() gives the test name
        et = er.createTest(context.getName(), "My first ExtentReport in TestNG");
        et.assignAuthor(author);
        et.assignDevice(device);
    }

    @AfterTest
    public void tearDown(ITestResult result) throws IOException {
        //closing the selenium WebDriver
        //driver.quit();
        Desktop.getDesktop().browse(new File("Tests.html").toURI());
    }


    @BeforeSuite
    public void initializeExtentReports() throws IOException {
        ExtentSparkReporter esr_all = new ExtentSparkReporter("Tests.html");
        //testing
        //esr_all.loadXMLConfig(new File("./src/test/resources/testng2.xml"));

        er = new ExtentReports();
        er.attachReporter(esr_all);

        //system related information
        er.setSystemInfo("OS Version",System.getProperty("os.version"));
        er.setSystemInfo("Java Version",System.getProperty("java.version"));
    }

    @AfterSuite
    public void generateExtentReports() throws IOException {
        er.flush();
        driver.quit();
        Desktop.getDesktop().browse(new File("Tests.html").toURI());
    }

    @AfterMethod
    //Another method for capturing failed screenshots
    // dependency Injection - ITestResult object
    public void screenshotCapture(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenShots(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
        }
    }

    @AfterMethod
    public static String captureScreenShots(String fileName) {

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
        return fileName;
    }

    @AfterMethod
    public void checkStatus(Method m , ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE ){
            String screenshotPath = null;
            screenshotPath = captureScreenShots(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
            et.addScreenCaptureFromPath(screenshotPath);
            et.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            et.pass(m.getName() + " is passed ");
        }
        // m.getAnnotation(Test.class).groups()
        et.assignCategory(m.getAnnotation(Test.class).groups());
    }
}
