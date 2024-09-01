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

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class ProductsAndProductDetailsTest {

    public final Logger log = LogManager.getLogger(ProductsAndProductDetailsTest.class);
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
        //Click on 'Products' button
        WebElement productElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productElement.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        //Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals(driver.getTitle(), "Automation Exercise - All Products");
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");
        //The products list is visible
        WebElement featureItemsElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div"));

        List<WebElement> allProductElements = featureItemsElement.findElements(By.className("col-sm-4"));
        assertEquals(allProductElements.size(), 34);

        // listing all the product items by tag p only
        // listing all the product items name
        for (WebElement element : allProductElements) {
            log.info("Peee paya is {}", element.findElement(By.tagName("p")).getText());
        }
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        // Click on 'View Product' of first product
        WebElement viewProductElement = driver.findElement(By
                .xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        viewProductElement.click();
        log.info("View Product of first Product is clicked");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");
        // User is landed to product detail page
        assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
        log.info("Product Details Page is {} ", driver.getTitle());
    }

    @Test(priority = 9)
    public void step9() {
        log.info("executing step 9");
        //Verify that detail is visible:
        //product name, category, price, availability, condition, brand
        WebElement productNameElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
        assertTrue(productNameElement.isDisplayed());
        log.info("product name {}", productNameElement.getText());

        WebElement categoryElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"));
        assertTrue(categoryElement.isDisplayed());
        log.info(categoryElement.getText());

        WebElement priceElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
        assertTrue(priceElement.isDisplayed());
        log.info("price {}", priceElement.getText());

        WebElement availabilityElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
        assertTrue(availabilityElement.isDisplayed());
        log.info(availabilityElement.getText());

        WebElement conditionElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
        assertTrue(conditionElement.isDisplayed());
        log.info(conditionElement.getText());

        WebElement brandElement = driver.findElement(By
                .xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));
        assertTrue(brandElement.isDisplayed());
        log.info(brandElement.getText());
    }
}

