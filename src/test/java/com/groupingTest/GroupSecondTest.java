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

public class GroupSecondTest extends BaseUtilTest {
    public final WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(GroupSecondTest.class);
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

    @Test(groups = "regression")
    public void fourthTest() {
        driver.manage().window().maximize();
        log.info("Test4");
    }

    @Test(groups = {"smoke", "sanity"})
    public void fifthTest() {
        log.info("Test5");
    }

    @Test(groups = {"smoke", "sanity"})
    public void sixthTest() {
        log.info("Test6");
    }

    @Test(groups = {"smoke", "functional"})
    public void seventhTest() {
        log.info("Test7");
    }
}
