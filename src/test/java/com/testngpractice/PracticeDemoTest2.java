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


public class PracticeDemoTest2 {
    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(PracticeDemoTest2.class);
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
    public void test4() {
        driver.manage().window().maximize();
        log.info("PRINTING TEST4");
        but.stopTheFlow(3);
    }

    @Test
    public void test5() {
        log.info("PRINTING TEST5");
        but.stopTheFlow(3);
    }

    @Test
    public void test6() {
        log.info("PRINTING TEST6");
        but.stopTheFlow(3);
    }
}
