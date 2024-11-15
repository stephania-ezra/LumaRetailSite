package com.groupingTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupFirstTest extends BaseUtilTest {

    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(GroupFirstTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test(groups = {"smoke", "sanity"})
    public void firstTest() {
        driver.manage().window().maximize();
        log.info("Test1");
    }

    @Test(groups = {"smoke", "sanity"})
    public void secondTest() {
        log.info("Test2");
    }

    @Test(groups = {"smoke", "sanity"})
    public void thirdTest() {
        log.info("Test3");
    }
}
