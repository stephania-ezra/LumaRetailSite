package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShopTeesTest {
    private final Logger log = LogManager.getLogger(ShopNewYogaTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    WebDriver driver = new ChromeDriver();

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
    public void homePage() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        assertEquals(driver.getTitle(), "Home Page");
        // clicking Shop Tees in home page
        WebElement shopTees = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]" +
                        "/div/div[2]/div[1]/div/a[2]/span[2]/span[2]"));
        shopTees.click();
    }

    @Test(priority = 2)
    public void teesPageProductNameSort() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/promotions/tees-all.html");
        assertEquals(driver.getTitle(), "Tees");
        // clicking Shop Tees in home page
        // clicking sortby options (Product Name)

        WebElement productName = driver.findElement(By.
                xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]"));
        productName.click();

        // Select Descending Direction
        // full xpath : /html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/a
        WebElement descendingdirection = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/a"));
        descendingdirection.click();

        driver.get("https://magento.softwaretestingboard.com/promotions" +
                "/tees-all.html?product_list_order=name&product_list_dir=desc");

        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        //Displaying the collections in teens page
        for (WebElement liElement : liElements) {

            //#maincontent > div.columns > div.column.main >
            // div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > strong > a
            WebElement TeesproductName = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("TeesproductName: {}", TeesproductName.getText());
        }
    }

    @Test(priority = 3)
    public void teesPagePriceSort() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/promotions/tees-all.html");
        assertEquals(driver.getTitle(), "Tees");
        // clicking Shop Tees in home page
        // clicking sortby options (Product Name)

        WebElement price = driver.findElement(By.
                xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]"));
        price.click();

        // if i give xpath : //*[@id="maincontent"]/div[3]/div[1]/div[2]/div[4]/ descending Price is not coming

        // Select Descending Direction
        /// copying full xpath for descending direction : html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/a
        WebElement descendingdirection = driver.findElement(By.
                xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/a"));
        descendingdirection.click();

        driver.get("https://magento.softwaretestingboard.com/promotions/" +
                "tees-all.html?product_list_order=price&product_list_dir=desc");
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        //Displaying the collections in teens page
        for (WebElement liElement : liElements) {

            //#maincontent > div.columns > div.column.main >
            // div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > strong > a
            WebElement TeesPrice = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("TeesPrice: {}", TeesPrice.getText());
        }
    }
}
