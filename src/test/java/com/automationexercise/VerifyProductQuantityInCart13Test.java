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
        //check with darli
        assertEquals(quantityButtonElement.getAttribute("value"), "4");
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        assertEquals(driver.getTitle(), "Automation Exercise - Product Details");

        //Click 'Add to cart' button
        WebElement addToCartButtonElement = driver.findElement(By.cssSelector("body > section > div > " +
                "div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button"));
        addToCartButtonElement.click();
        log.info("Add to Cart button is Clicked");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");
        but.stopTheFlow(5);
        //Click 'View Cart' button
        WebElement viewCartElement = driver.findElement(By
                .xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"));
        viewCartElement.click();
    }

    @Test(priority = 9)
    public void step9() {
        log.info("executing step 9");
        assertEquals(driver.getTitle(), "Automation Exercise - Checkout");

        //Verify that product is displayed in cart page with exact quantity
        //retrieving table details
        WebElement table = driver.findElement(By.id("cart_info_table"));
        List<WebElement> headers = table.findElements(By.tagName("td"));
        for (WebElement header : headers) {
            String text = header.getText();
            log.info(text);
        }
        List<WebElement> allRows = table.findElements(By.cssSelector("tbody tr"));
        int size = allRows.size();
        log.info("Rows size: " + size);
        if (size == 1) {
            log.info("pass");
        } else log.info("fail");

        for (WebElement row : allRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            WebElement thirdColumn = columns.get(3);
            log.info(thirdColumn.getText());
            assertEquals(thirdColumn.getText(), "4");
        }
    }
}