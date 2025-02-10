package com.practisingDaily.screenshotTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtendedReportTest extends BaseTest {

    private final Logger log = LogManager.getLogger(ExtendedReportTest.class);

    @Test(testName = "TestGoogle", groups={"smoke"})
    public void googleTest() throws Exception {

        log.info("First Test: Google Test");
        extentTest.info("Navigated to URL");
        driver.get("https://www.google.co.in");

        Thread.sleep(3000);
        WebElement inputHYRElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]" +
                "/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"));
        extentTest.info("Entered Text in Search box");
        inputHYRElement.sendKeys("HYR Tutorials", Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search", "Title Mismatch");
        extentTest.fail("Assertion test is passed for WebPage Title");
    }

    @Test(testName = "TestOrangeHRM",groups = {"smoke","Regression"})
    public void orangeHRMTest() throws Exception {
        log.info("OrangeHRMTest");
        extentTest.info("Navigated to URL");
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
        extentTest.pass("Test is passed for OrangeHRM Login");

    }
}
