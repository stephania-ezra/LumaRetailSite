package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.dataproviders.TestLumaDataProviders;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class ErinRecommendsTest {
    private final Logger log = LogManager.getLogger(MensDealsTest.class);
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
    public void erinRecomm() {

        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        assertEquals(driver.getTitle(), "Home Page");

        WebElement shopErinElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/" +
                        "div[2]/div[1]/div/a[3]/span/span[2]"));
        shopErinElement.click();

        // Listing the items in the page - 12 items

        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        for (WebElement liElement : liElements) {
            // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > strong > a
            WebElement erinRecommendsTitle = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("erinRecommendsTitle: {}", erinRecommendsTitle.getText());
        }
    }

    @Test(priority = 2)
    public void pagination() {

        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/collections/erin-recommends.html");
        assertEquals(driver.getTitle(), "Erin Recommends");


        WebElement nextPage = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[3]/a"));
        nextPage.click();

        // Listing the items in the page - 12 items
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        for (WebElement liElement : liElements) {
            WebElement erinRecommendsTitle2 = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("erinRecommendsTitle2: {}", erinRecommendsTitle2.getText());
        }
    }

    @Test(priority = 3)
    public void reviews() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/collections/erin-recommends.html");
        assertEquals(driver.getTitle(), "Erin Recommends");

        //Listing the reviews of all the items in the first page
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        for (WebElement liElement : liElements) {
            //#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol >
            // li:nth-child(1) > div > div > div.product-reviews-summary.short > div.reviews-actions > a
            try {
                WebElement reviewElement = liElement.findElement(By.cssSelector(" div > div > " +
                        "div.product-reviews-summary.short > div.reviews-actions"));
                log.info("reviewElement: {}", reviewElement.getText());
            } catch (NoSuchElementException e) {
                log.error("review not found");
            }
        }
    }

    /**
     * This method uses data provider test
     *
     * @param url URL
     */
    @Test(priority = 4, dataProvider = "recommendedURLS", dataProviderClass = TestLumaDataProviders.class)
    public void erinFirstPagePrice(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        log.info("working on {}", url);
        assertEquals(driver.getTitle(), "Erin Recommends");

        ////*[@id="product-price-2040"]/span

        ////*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[2]

        //listing the price of each items in first page
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        //#maincontent > div.columns > div.column.main >
        // div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > div > div.price-box.price-final_price
        for (WebElement liElement : liElements) {
            WebElement erinRecommendsPrice = liElement.
                    findElement(By.cssSelector("div > div > div.price-box.price-final_price"));
            log.info("erinRecommendsPrice: {}", erinRecommendsPrice.getText());
        }
    }

    @Test(priority = 5)
    public void erinFirstPageSize() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/collections/erin-recommends.html?p=1");
        assertEquals(driver.getTitle(), "Erin Recommends");

        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        for (WebElement liElement : liElements) {
            // if any hierarchy value have unique class name or attribute name then you
            // can simply use * to ignore them

            //xpath ://*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]
            //css selector : #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid >
            // ol > li:nth-child(1) > div > div > div.swatch-opt-2040 > div.swatch-attribute.size

            try {
                WebElement errinPageoneSizes = liElement.
                        findElement(By.cssSelector("* > div.swatch-attribute.size > div"));
                log.info("errinPageoneSizes: {}", errinPageoneSizes.getText());
            } catch (NoSuchElementException e) {
                log.error("size not found");
            }
        }
    }
}
