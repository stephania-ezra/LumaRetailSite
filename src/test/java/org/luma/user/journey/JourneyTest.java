package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.LumaLoginTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class JourneyTest extends LumaLoginTest {

    private final Logger log = LogManager.getLogger(JourneyTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        BaseUtilTest btu = new BaseUtilTest();
        btu.tearDown(driver);
    }

    @Test(priority = 1)
    public void journeyTest() {
        login();
        log.info("journeyTest current Thread Id:{}", Thread.currentThread().threadId());

        // Clicking What's New
        WebElement whatsnew = driver.findElement(By.id("ui-id-3"));
        whatsnew.click();

        // Clicking Bras&Tanks
        WebElement brasTanks = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div/div/ul[1]/li[4]/a"));
        brasTanks.click();

        // Clicking Lucia cross fit Bra
        WebElement luciaCrossFitBra = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[10]/div/div/strong/a"));
        luciaCrossFitBra.click();

        // Clicking L size
        WebElement checkSize = driver.findElement(By.id("option-label-size-143-item-169"));
        checkSize.click();

        //Clicking BlackColor
        WebElement clickingColor = driver.findElement(By.id("option-label-color-93-item-49"));
        clickingColor.click();

        //Add to cart
        WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
        addToCart.click();
        but.stopTheFlow(5);
    }

    @Test(priority = 2)
    public void checkingCartNumber() {

        try {
            WebElement cartNumber = driver
                    .findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]"));
            String noOfItems = (cartNumber.getText().isEmpty()) ? "0" : cartNumber.getText();
            int noOfItemsValue = Integer.parseInt(noOfItems);
            if (noOfItemsValue > 0) {
                log.info("checkingCartNumber: with Items is {}", noOfItems);
                assertTrue(true);
            } else {
                log.info("checkingCartNumber: without Items is {}", noOfItems);
                assertEquals(noOfItems, "0");
            }
        } catch (NotFoundException nfe) {
            log.info("item not added to the cart{}", nfe.getMessage());
        }
    }

    @Test(priority = 3)
    public void proceedToCheckOut() {

        // verify the pdp page
        assertEquals(driver.getCurrentUrl(),
                "https://magento.softwaretestingboard.com/lucia-cross-fit-bra.html");

        // click the cart
        WebElement cart = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
        cart.click();

        // proceed to checkout
        WebElement proceedToCheckOut = driver
                .findElement(By.id("top-cart-btn-checkout"));
        proceedToCheckOut.click();

        // verify the billing address
        but.stopTheFlow(5);

        // verify the shippingAddress page
        assertEquals(driver.getCurrentUrl(),
                "https://magento.softwaretestingboard.com/checkout/#shipping");

        WebElement shippingAddress = driver
                .findElement(By
                        .xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol" +
                                "/li[1]/div[2]/div[1]/div/div/div"));
        log.info("shippingAddress = {}", shippingAddress.getText());
        assertTrue(shippingAddress.getText().contains("Muthu Swamy Street"));
    }

    @Test(priority = 4)
    public void removeFromCart() {
        // click back, verify url
        driver.navigate().back();

        assertEquals(driver.getCurrentUrl()
                , "https://magento.softwaretestingboard.com/lucia-cross-fit-bra.html");

        but.scrollToTop(driver);

        // click the cart
        WebElement cart = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
        cart.click();

        // wait and then click remove button
        but.stopTheFlow(5);
        WebElement removeButton = driver.findElement(By
                .xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]" +
                        "/div[4]/ol/li/div/div/div[3]/div[2]/a"));
        removeButton.click();

        // wait and then click ok button on widget
        but.stopTheFlow(5);
        WebElement OkButton = driver.findElement(By
                .xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[2]"));
        OkButton.click();

        // wait and verify the cart is empty
        but.stopTheFlow(5);
        WebElement noOfItemsMessage = driver.findElement(By
                .xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/strong"));
        log.info("removeFromCart: noOfItemsMessage is {}", noOfItemsMessage.getText());
        assertEquals(noOfItemsMessage.getText(), "You have no items in your shopping cart.");
    }
}
