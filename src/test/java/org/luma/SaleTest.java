package org.luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SaleTest extends LumaLoginTest {

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

    @Test(priority = 1)
    public void openSalePage() {
        System.out.println("running openSalePage from " + Thread.currentThread().threadId());
        login();

        // sale on HomePage
        WebElement sale = driver
                .findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[6]/a/span"));
        sale.click();

        // Shop Women's Deals Button on Sale Page
        WebElement shopWomenDeals = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[1]/div/a/span/span[2]"));
        shopWomenDeals.click();

        // Checking the Women Sale Deal Page
        assertEquals(driver.getCurrentUrl()
                , "https://magento.softwaretestingboard.com/promotions/women-sale.html");
    }

    @Test(priority = 2)
    public void dSortByHighestPrice() {
        // Dropdown on Sale Page
        WebElement sorter = driver.findElement(By.id("sorter"));
        sorter.click();

        // Price from the Dropdown
        WebElement price = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[3]" +
                        "/div[1]/div[2]/div[4]/select/option[3]"));
        price.click();

        // Select Descending Direction
        WebElement descendingdirection = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/a"));
        descendingdirection.click();
    }

    @Test(priority = 3)
    public void addToWishList() {
        // Open First Dress Item
        WebElement firstDress = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]" +
                        "/div[3]/ol/li[1]/div/a/span/span/img"));
        firstDress.click();

        // Check PDP Page
        assertEquals(driver.getCurrentUrl()
                , "https://magento.softwaretestingboard.com/olivia-1-4-zip-light-jacket.html");

        WebElement addToWishList = driver.findElement(By
                .xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]/span"));
        addToWishList.click();
    }
}
