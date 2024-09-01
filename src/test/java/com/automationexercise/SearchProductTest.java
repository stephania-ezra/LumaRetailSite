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
public class SearchProductTest {

    public final Logger log = LogManager.getLogger(SearchProductTest.class);
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
        WebElement productButtonElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productButtonElement.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        //Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals(driver.getTitle(), "Automation Exercise - All Products");
    }

    @Test(priority = 6)
    public void step6andStep7() {
        log.info("executing step 6 and step 7");
        //Enter product name in search input and click search button
        WebElement searchInputElement = driver.findElement(By.id("search_product"));
        searchInputElement.sendKeys("Winter Top");

        WebElement searchButtonElement = driver.findElement(By.cssSelector("#submit_search"));
        searchButtonElement.click();

        WebElement searchedElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/p"));
        assertEquals(searchInputElement.getText(), searchedElement);
        log.info("Searched Product is displayed {}", searchedElement.getText());
    }
}
