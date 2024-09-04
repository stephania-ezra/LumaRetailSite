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

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class VerifyProductQuantityInCart13Test {

    public final Logger log = LogManager.getLogger(VerifyProductQuantityInCart13Test.class);
    public WebDriver driver = new ChromeDriver();
    BaseUtilTest but = new BaseUtilTest();
    List<WebElement> allProductElements = new ArrayList<>();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
//        but.logoutAutomationExercise(driver);
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

        //Click 'View Product' for any product on home page
        WebElement viewProductElement = driver.findElement(By
                .xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        viewProductElement.click();
        log.info("View Product of first Product is clicked");
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");

        //Verify product detail is opened
        assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
        log.info("Product Details Page is {} ", driver.getTitle());
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");

        //Increase quantity to 4
        WebElement quantityButtonElement = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
        quantityButtonElement.clear();
        quantityButtonElement.sendKeys("4");
    }
}