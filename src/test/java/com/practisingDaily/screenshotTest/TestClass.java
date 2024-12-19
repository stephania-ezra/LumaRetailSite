package com.practisingDaily.screenshotTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;

public class TestClass extends BaseTest {
    public static WebDriver driver;
    private final Logger log = LogManager.getLogger(TestClass.class);

    @Test(testName = "TestGoogle", groups={"smoke"})
    public void googleTest() throws Exception {
        driver = new ChromeDriver();
        log.info("First Test: Google Test");
        et.info("Navigated to URL");
        driver.get("https://www.google.co.in/?gws_rd=cr");

        Thread.sleep(3);
        WebElement inputHYRElement = driver.findElement(By.name("q"));
        et.info("Entered Text in Search box");
        inputHYRElement.sendKeys("HYR Tutorials", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search", "Title Mismatch");
        et.fail("Assertion test is passed for WebPage Title");

    }

    @Test(testName = "TestOrangeHRM",groups = {"smoke","Regression"})
    public void orangeHRMTest() throws Exception {
        log.info("OrangeHRMTest");
        et.info("Navigated to URL");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3);

        driver.wait();
        WebElement userNameElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/" +
                        "div[2]/form/div[1]/div/div[2]/input"));
        userNameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/" +
                        "div[2]/form/div[2]/div/div[2]/input"));
        passwordElement.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By
                .cssSelector("#app > div.orangehrm-login-layout > div > " +
                        "div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > " +
                        "form > div.oxd-form-actions.orangehrm-login-action > button"));
        loginButton.click();
        et.pass("Test is passed for OrangeHRM Login");

    }
}
