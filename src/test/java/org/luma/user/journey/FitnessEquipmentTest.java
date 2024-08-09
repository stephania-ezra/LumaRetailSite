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

@Listeners({CustomListener.class})
public class FitnessEquipmentTest extends LumaLoginTest {
    private final Logger log = LogManager.getLogger(MensDealsTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        but.tearDown(driver);
    }

    @Test(priority = 1)
    public void FitnessEquipment() {
        driver.get("https://magento.softwaretestingboard.com");
        but.stopTheFlow(5);
        log.info("MensDealsTest current Thread Id:{}", Thread.currentThread().threadId());

        //click Gear
        WebElement gear = driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/span[2]"));
        gear.click();

        //click Shop Equipment
        WebElement shopEquipment = driver.
                findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/" +
                        "div[1]/div[1]/div[2]/a[2]/span[1]/span[2]"));
        shopEquipment.click();

        //Listing the elements in Shop Equipment page

        WebElement olElement = driver.
                findElement(By.xpath(" //*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));

        log.info("liElements.size {} ", liElements.size());
        for (WebElement liElement : liElements) {
            // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > strong > a
            WebElement euipmentTitle = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("euipmentTitle: {}", euipmentTitle.getText());

            //Listing the price
            //#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > div.price-box.price-final_price
            WebElement equipmentPrice = liElement.findElement(By.cssSelector("div > div > div.price-box.price-final_price"));
            log.info("equipmentPrice: {}", equipmentPrice.getText());
        }


    }
}