package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WishlistTest extends LumaLoginTest {

    @AfterTest
    void tearDown() {
        BaseTestUtils.tearDown(driver);
    }

    @Test
    public void wishlist() {
        login();

        // Dropdown in Profile
        WebElement signOutToggleButton = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
        signOutToggleButton.click();


        WebElement myWishList = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a"));
        myWishList.click();

        // Message in Wishlist
        WebElement message = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/span"));
        System.out.println("message " + message.getText());
        assertEquals(message.getText(), "You have no items in your wish list.");
    }
}
