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
public class PlaceOrderRegisterWhileCheckout14Test {

    public final Logger log = LogManager.getLogger(PlaceOrderRegisterWhileCheckout14Test.class);
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
        //Add products to cart
        but.scrollToMiddle(driver);
        WebElement featureItemsElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div"));

        allProductElements = featureItemsElement.findElements(By.className("col-sm-4"));
        WebElement firstProductElement = allProductElements.getFirst();

        WebElement addToCartElement = firstProductElement.findElement(By.tagName("a"));
        but.hoverTheElement(driver, addToCartElement);
        addToCartElement.click();
        log.info("First Product Added to Cart");
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");

        but.stopTheFlow(2);
        // Click 'Cart' button
        WebElement viewElement = driver.findElement(By
                .xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"));
        viewElement.click();
    }
/*
    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        // Verify that cart page is displayed
        assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");

        // Click Proceed To Checkout
        WebElement ProceedToCheckoutElement = driver.findElement(By
                .cssSelector("#do_action > div.container > div > div > a"));
        ProceedToCheckoutElement.click();
    }

    @Test(priority = 9)
    public void step9() {
        log.info("executing step 9");
        but.stopTheFlow(5);

        // Click 'Register / Login' button
        WebElement checkOutElement = driver.findElement(By
                .xpath("//*[@id=\"checkoutModal\"]/div/div/div[1]/h4"));
        assertEquals(checkOutElement.getText(), "Checkout");

        WebElement registerOrLoginButtonElement = driver
                .findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
        registerOrLoginButtonElement.click();
    }*/
}

