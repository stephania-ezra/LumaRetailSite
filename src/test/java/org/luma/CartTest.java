package org.luma;

import org.luma.dataproviders.TestLumaDataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends LumaLoginTest {

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
    void connect() {
        login();
    }

    @Test(priority = 2, dataProvider = "otherProducts", dataProviderClass = TestLumaDataProviders.class)
    public void addBagsToCart(List<String> item) {
        System.out.println(item.get(0) + " adding product to cart");
        driver.get(item.get(1));

        WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
        addToCart.click();
    }

    @Test(priority = 3, dataProvider = "jacketProducts", dataProviderClass = TestLumaDataProviders.class)
    public void addJacketsToCart(List<String> item) {
        System.out.println(item.get(0) + " adding product to cart");
        driver.get(item.get(1));

        WebElement size = driver.findElement(By.id("option-label-size-143-item-169"));
        size.click();

        WebElement color = driver.findElement(By.id("option-label-color-93-item-50"));
        color.click();

        WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
        addToCart.click();
    }
}
