package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.dataproviders.TestLumaDataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShopNewYogaTest {
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

        //clicking the Shop New yoga in Home Page
        ////*[@id="maincontent"]/div[3]/div/div[2]/div[1]/a/span/span[2]
        WebElement shopNewYoga = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]" +
                        "/div/div[2]/div[1]/a/span/span[2]"));
        shopNewYoga.click();
        log.info("New Luma Yoga Collections Page");
    }

    @Test(priority = 2)
    public void newLumaYogaCollections() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/collections/yoga-new.html");
        assertEquals(driver.getTitle(), "New Luma Yoga Collection");

        ////*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        //Displaying the collections in first page
        for (WebElement liElement : liElements) {

            //#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol >
            // li:nth-child(1) > div > div > strong > a
            WebElement FirstPageCollections = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("FirstPageCollections: {}", FirstPageCollections.getText());
        }
    }

    @Test(priority = 3, dataProvider = "recommendedURLSNew", dataProviderClass = TestLumaDataProviders.class)
    public void pagination(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        log.info("working on {}", url);
        assertEquals(driver.getTitle(), "New Luma Yoga Collection");

        //Listing 2nd page collections
        ////*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a 2nd page
        ////*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a 3rd page

        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));
        log.info("liElements.size {} ", liElements.size());

        for (WebElement liElement : liElements) {
            //#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid >
            // ol > li:nth-child(1) > div > div > strong > a
            WebElement collections = liElement.findElement(By.cssSelector("div > div > strong > a"));
            log.info("collections: {}", collections.getText());
        }
    }

    @Test(priority = 4, dataProvider = "recommendedURLSNew", dataProviderClass = TestLumaDataProviders.class)
    public void paginationReviews(String url) {
        // Listing the Reviews , Price , Size and Color of 2nd and 3rd Page
        driver.manage().window().maximize();
        driver.get(url);
        log.info("working on {}", url);
        assertEquals(driver.getTitle(), "New Luma Yoga Collection");

        ////*[@id="maincontent"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[1]
        WebElement olElement = driver
                .findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol"));
        List<WebElement> titleElements = olElement.findElements(By.tagName("li"));
        log.info("titleElements.size {} ", titleElements.size());

        for (WebElement liElement : titleElements) {
            try {
                String title = "default";
                String review = "default";
                String rating = "";
                String price = "";
                String swatchOptions = "";
                String swatchSize = "";

                // title
                WebElement titleElement = liElement.findElement(By.cssSelector("div > div > strong > a"));
                title = titleElement.getText();

                // rating
                try {
                    WebElement ratingElement = liElement.findElement(By
                            .cssSelector("div > div > div.product-reviews-summary.short > div.rating-summary " +
                                    "> div > span > span"));
                    rating = ratingElement.getText();

                    // review
                    WebElement reviewElement = liElement.findElement(By
                            .cssSelector("div > div > div.product-reviews-summary.short > div.reviews-actions"));
                    review = reviewElement.getText();

                    // price
                    WebElement priceElement = liElement.findElement(By
                            .cssSelector("div > div > div.price-box.price-final_price > span > span "));
                    price = priceElement.getText();

                    // size
                    // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)
                    // > div > div > div.swatch-opt-1268 > div.swatch-attribute.size > div
                    WebElement sizeElement = liElement
                            .findElement(By.cssSelector("div > div > div > div.swatch-attribute.size > div"));
                    List<WebElement> swatchSizeDivs = sizeElement.findElements(By.tagName("div"));
                    swatchSize = "";
                    for (WebElement swatchSizeElement : swatchSizeDivs) {
                        swatchSize = swatchSize.concat(swatchSizeElement.getAttribute("option-label"));
                        swatchSize = swatchSize.concat(" ");
                    }

                    // colors
                    // #maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)
                    // div.product.details.product-item-details div.swatch-opt-1997
                    // div.swatch-attribute.color div.swatch-option.color
                    // I learnt to take li elements div tag without taking ol tag (below is the syntax)
                    // div is individual items not like a list .But here we are taking div like a list
                    WebElement colorElement = liElement.findElement(By
                            .cssSelector("div div div.swatch-attribute.color > div.swatch-attribute-options"));
                    List<WebElement> swatchDivs = colorElement.findElements(By.tagName("div"));
                    swatchOptions = "";
                    for (WebElement color : swatchDivs) {
                        swatchOptions = swatchOptions.concat(color.getAttribute("option-label"));
                        swatchOptions = swatchOptions.concat(" ");
                    }
                } catch (Exception e) {
                    //review = "default";
                    //rating = "default";
                    //swatchSize = "default";
                    //swatchOptions = "default";
                }
//                log.info(liElement.findElement(By.cssSelector(" div div div.swatch-attribute.color div.swatch-option.color")).getAttribute("option-label"));

                // print everything in one line
                log.info("Title: {},  rating: {}, reviews: {}, size: {}, price: {}, color: {}"
                        , title
                        , rating
                        , review
                        , swatchSize
                        , price
                        , swatchOptions);

            } catch (NoSuchElementException e) {
                log.error("size not found");
            }
        }
    }
}
