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
public class AddProductCartPageTest {

    public final Logger log = LogManager.getLogger(AddProductCartPageTest.class);
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
        //Click on 'Products' button
        WebElement productElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productElement.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        but.stopTheFlow(5);
        assertEquals(driver.getTitle(), "Automation Exercise - All Products");
        //Hover over first product and click 'Add to cart'
        but.scrollToMiddle(driver);
        WebElement featureItemsElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div"));

        allProductElements = featureItemsElement.findElements(By.className("col-sm-4"));
        WebElement firstProductElement = allProductElements.getFirst();

        WebElement addToCartElement = firstProductElement.findElement(By.tagName("a"));
        addToCartElement.click();
        log.info("First Product Added to Cart");
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");
        //click Continue shopping Button
        but.stopTheFlow(5);
        WebElement addedElement = driver.findElement(By
                .xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4"));
        assertEquals(addedElement.getText(), "Added!");

        WebElement continueShoppingButtonElement = driver
                .findElement(By.cssSelector("#cartModal > div > div > div.modal-footer > button"));
        continueShoppingButtonElement.click();
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        //Hover over second product and click 'Add to cart'
        WebElement featureItemsElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div"));
        WebElement secondProductElement = allProductElements.get(1);
        but.hoverTheElement(driver, secondProductElement);

        but.scrollToMiddle(driver, "300, 500");
        WebElement addToCartElement = secondProductElement.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"));
        addToCartElement.click();
        log.info("Second Product Added to Cart");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");
        but.stopTheFlow(5);
        WebElement addedElement = driver.findElement(By
                .xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4"));
        assertEquals(addedElement.getText(), "Added!");

        //Click 'View Cart' button
        WebElement viewCartElement = driver.findElement(By
                .xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"));
        viewCartElement.click();
    }

    @Test(priority = 9)
    public void step9() {
        log.info("executing step 9");
        //Verify both products are added to Cart
        assertEquals(driver.getTitle(), "Automation Exercise - Checkout");

        //retrieving table details
        WebElement table = driver.findElement(By.id("cart_info_table"));
        List<WebElement> headers = table.findElements(By.tagName("td"));
        for (WebElement header : headers) {
            String text = header.getText();
            log.info(text);
        }

        /*WebElement featureItemsElement = driver.findElement(By
                .xpath("/html/body/section[2]/div[1]/div/div[2]/div"));
        allProductElements = featureItemsElement.findElements(By.className("col-sm-4"));
        WebElement firstProductElement = allProductElements.getFirst();
        WebElement secondProductElement = allProductElements.get(1);

        /*List<WebElement> rowsNumber = driver.findElements(By.xpath("//*[@id=\"product-1\"]"));
        int rowCount = rowsNumber.size();
        assertEquals(rowsNumber.size(), 2);

        // Verify their prices, quantity and total price
        for (WebElement element : rowsNumber) {

            WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p"));
            WebElement quantityElement = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
            WebElement totalPriceElement = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p"));

            log.info("priceElement: {}, quantityElement: {}, totalPriceElement: {}", quantityElement.getText(), totalPriceElement.getText());
        }*/
    }
}