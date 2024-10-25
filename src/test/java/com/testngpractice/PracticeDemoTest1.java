package com.testngpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PracticeDemoTest1 {
    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(PracticeDemoTest1.class);
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

    @Test
    public void test1() {
        driver.manage().window().maximize();
        log.info("PRINTING TEST1");
        but.stopTheFlow(3);
    }

    @Test
    public void test2() {
        log.info("PRINTING TEST2");
        but.stopTheFlow(3);
    }

    @Test
    public void test3() {
        log.info("PRINTING TEST3");
        but.stopTheFlow(3);
    }
}
