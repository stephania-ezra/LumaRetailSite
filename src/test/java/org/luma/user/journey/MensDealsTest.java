package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.LumaLoginTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class MensDealsTest extends LumaLoginTest {

    private final Logger log = LogManager.getLogger(MensDealsTest.class);
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
    public void deals() {
        login();
        log.info("MensDealsTest current Thread Id:{}", Thread.currentThread().threadId());

        //clicking sale
        WebElement sale = driver.findElement(By.xpath("//*[@id=\"ui-id-8\"]/span"));
        sale.click();

        //clicking Shop Men's Deals
        WebElement shopMensDeals = driver.
                findElement(By.
                        xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/" +
                                "div[1]/div/div[1]/a[1]/span/span[2]"));
        shopMensDeals.click();
        but.stopTheFlow(5);
    }

    @Test(priority = 2)
    public void checkingShopMensDeals() {
        //clicking sale dropdown
        WebElement saleDropDown = driver.findElement(By.
                xpath("//*[@id=\"narrow-by-list\"]/div[12]/div[1]"));
        saleDropDown.click();

        //clicking "yes" under the sale shopping options

        WebElement yesOption = driver.findElement(By.
                xpath("//*[@id=\"narrow-by-list\"]/div[12]/div[2]/ol/li/a"));
        yesOption.click();
        but.stopTheFlow(5);
    }

    @Test(priority = 3)
    public void listingMenSale() {

        //Navigating to Sale options yes page
        log.info("Listing Men Sale current Thread Id:{}", Thread.currentThread().threadId());

        driver.get("https://magento.softwaretestingboard.com/promotions/men-sale.html?sale=1");
        assertEquals(driver.getTitle(), "Men Sale");

        // trying to get the details of men sale items
        WebElement olElement = driver.
                findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {}", liElements.size());


        for (WebElement liElement : liElements) {
            // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > strong > a
            WebElement productTitleElement = liElement.findElement(By.cssSelector("div > div > strong > a"));

            // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > div.price-box.price-final_price > span > span > span.price-label
            WebElement priceElement = liElement
                    .findElement(By
                            .cssSelector("div > div > div.price-box.price-final_price > span"));
            log.info("productTitleElement: {}, priceElement: {}", productTitleElement.getText(), priceElement.getText());
        }
    }
}
