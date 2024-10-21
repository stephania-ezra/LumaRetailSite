package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class OrangeAssertionTest {
    public final Logger log = LogManager.getLogger(OrangeAssertionTest.class);
    public final WebDriver driver = new ChromeDriver();
    public final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("Setting Context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test
    public void TestFacebook() {
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement userNameElement = driver.findElement(By.id("email"));
        userNameElement.sendKeys("Tutorials", Keys.ENTER);

        //Title Assertion
        assertEquals(driver.getTitle(), "Log in to Facebook", "Title Mismatch");
        log.info("Title is similar");

        //URL Assertion
        assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "URL Mismatch");
        log.info("URL Matches");

        //Text Assertion
        String actualText = driver.findElement(By.id("email")).getAttribute("value");
        String expectedText = "";
        assertEquals(actualText, expectedText, "Text Mismatch");
        log.info("Username is Empty");

        //Error Message Assertion
        WebElement errorMessageElement = driver.findElement((By
                .xpath("//*[@id=\"email_container\"]/div[2]")));
        assertEquals(errorMessageElement.getText(),
                "The email address or mobile number you entered isn't connected to an account." +
                        " Find your account and log in.", "Invalid  Error Message");
        log.info("Valid Error Message is displayed");


        //SoftAssertion -> Replace assert with softAssert
        /*SoftAssert softAssert = new SoftAssert();


        //Title Assertion
        softAssert.assertEquals(driver.getTitle(), "Log in to Facebook", "Title Mismatch");
        log.info("Title is similar");

        //URL Assertion
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "URL Mismatch");
        log.info("URL Matches");

        //Text Assertion
        String actualText = driver.findElement(By.id("email")).getAttribute("value");
        String expectedText = "";
        softAssert.assertEquals(actualText, expectedText, "Text Mismatch");
        log.info("Username is Empty");

        //Error Message Assertion
        WebElement errorMessageElement = driver.findElement((By
                .xpath("//*[@id=\"email_container\"]/div[2]")));
        softAssert.assertEquals(errorMessageElement.getText(),
                "The email address or mobile number you entered isn't connected to an account." +
                        " Find your account and log in.", "Invalid  Error Message");
        log.info("Valid Error Message is displayed");

        softAssert.assertAll();
         */
    }
}
