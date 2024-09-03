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
public class VerifySubscriptionCartPageTest {

    public final Logger log = LogManager.getLogger(VerifySubscriptionCartPageTest.class);
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
        log.info("Home Page is visible");
    }

    @Test(priority = 4)
    public void step4() {
        log.info("executing step 4");
        //Click 'Cart' button
        WebElement cartButtonElement = driver
                .findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        cartButtonElement.click();
        log.info("Clicking Cart Button");
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        //Scroll down to footer
        but.scrollToFooter(driver);
        log.info("scrolling down to Footer");
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");
        //Verify text 'SUBSCRIPTION'
        WebElement subscriptionElement = driver.findElement(By
                .xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        assertEquals(subscriptionElement.getText().toUpperCase(), "SUBSCRIPTION");
        log.info("Text {} is verified", driver.getTitle());
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        //Enter email address and click arrow button
        WebElement emailAddressElement = driver.findElement(By.id("susbscribe_email"));
        emailAddressElement.sendKeys("collins.einstein@gmail.com");
        log.info("Email Address {} is given", emailAddressElement.getText());

        WebElement arrowButtonElement = driver.findElement(By.cssSelector("#subscribe > i"));
        arrowButtonElement.click();
        log.info("arrow button is clicked");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");

        //Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessageElement = driver.findElement(By
                .xpath("//*[@id=\"success-subscribe\"]/div"));
        assertEquals(successMessageElement.getText(), "You have been successfully subscribed!");
        log.info("Success Message: {}", successMessageElement.getText());
    }
}
