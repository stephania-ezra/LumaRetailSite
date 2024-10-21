package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({CustomListener.class})
public class AnnotationsTest extends BaseUtilTest {

    public final Logger log = LogManager.getLogger(AnnotationsTest.class);
    public final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("setting Context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test
    public void testMethod1() {
        log.info("Test Method1");
    }

    @Test
    public void testMethod2() {
        log.info("Test Method2");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Testing Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        log.info("Testing After Method");
    }

    @BeforeSuite
    public void beforeSuite() {
        log.info("Testing Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        log.info("Testing After Suite");
    }
}
