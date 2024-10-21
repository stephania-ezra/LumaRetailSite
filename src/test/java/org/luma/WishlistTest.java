package org.luma;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WishlistTest extends LumaLoginTest {

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        BaseUtilTest btu = new BaseUtilTest();
        btu.tearDown(driver);
    }

    @Test
    public void wishlist() {
        System.out.println("running wishlist from " + Thread.currentThread().threadId());
        login();

        // Dropdown in Profile
        WebElement signOutToggleButton = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
        signOutToggleButton.click();


        WebElement myWishList = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a"));
        myWishList.click();

        try {
            WebElement profileItemCount = driver.findElement(By
                    .xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a/span"));
            if (profileItemCount.isDisplayed()) {
                WebElement message = driver.findElement(By
                        .xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div/p/span"));
                System.out.println("My Wish List count " + message.getText());
                assertTrue(message.isDisplayed());
            }
        } catch (StaleElementReferenceException sere) {
            System.out.println("stale error while checking for items in wish list");
        }

        try {
            // Message in Wishlist
            WebElement message = driver
                    .findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/span"));
            System.out.println(message.getText());
            assertEquals(message.getText(), "You have no items in your wish list.");
        } catch (StaleElementReferenceException | NoSuchElementException sere) {
            System.out.println("stale error while check for no items in wish list");
        }
    }
}
