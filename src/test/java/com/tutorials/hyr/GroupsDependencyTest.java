package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupsDependencyTest extends BaseUtilTest {
    private final Logger log = LogManager.getLogger(GroupsDependencyTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test(groups = "smoke")
    public void FirstTest() {
        log.info("Test1 running under Smoke Group");
    }

    @Test(groups = "smoke")
    public void SecondTest() {
        log.info("Test2 running under Smoke Group");
    }

    @Test(groups = "smoke")
    public void ThirdTest() {
        // log.info(5 / 0);
        log.info("Third test running under smoke Group");
    }

    @Test(dependsOnGroups = {"smoke", "sanity", "regression"})
    public void FourthTest() {
        log.info("Main Test depending upon Smoke and sanity Group");
    }

    @Test(groups = "sanity")
    public void FifthTest() {
        log.info("Fifth Test running under sanity Group");
    }

    @Test(groups = "sanity")
    public void SixthTest() {
        log.info(5 / 0);
        //log.info("Sixth Test running under sanity Group");
    }

    @Test(groups = "regression")
    public void SeventhTest() {
        log.info("Seventh Test running under Regression Group");
    }

    @Test(groups = "regression")
    public void EighthTest() {
        log.info("Eighth Test running under regression Group");
    }
}
