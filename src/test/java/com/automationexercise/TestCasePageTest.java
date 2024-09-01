package com.automationexercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class TestCasePageTest {

    public final Logger log = LogManager.getLogger(TestCasePageTest.class);
    public WebDriver driver = new ChromeDriver();
    BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        but.logoutAutomationExercise(driver);
    }

    @Test(priority = 1)
    public void step1() {
        log.info("executing step 1");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void step2() {
        log.info("executing step 2");
        driver.get("http://automationexercise.com");
    }

    @Test(priority = 3)
    public void step3() {
        log.info("executing step 3");
        assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @Test(priority = 4)
    public void step4() {
        log.info("executing step 4");
        //Click on 'Test Cases'
        WebElement testCaseElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        testCaseElement.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        //Verify user is navigated to test cases page successfully
        assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases");
    }
}

