package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReviewsTest {

    private final Logger log = LogManager.getLogger(ReviewsTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    private final WebDriver driver = new ChromeDriver();

    @AfterClass
    void tearDown() {
        but.tearDown(driver);
    }

    @Test
    public void Reviews() {
        // Navigating to the given URL
//        driver.get("https://magento.softwaretestingboard.com/didi-sport-watch.html");
        driver.get("https://magento.softwaretestingboard.com/montana-wind-jacket.html");
        log.info("Didi Sport Watch Page is displayed");
        but.stopTheFlow(5);

        // Click Reviews Tab
        WebElement reviewTab = driver.findElement(By.id("tab-label-reviews-title"));
        reviewTab.click();
        but.stopTheFlow(5);

        // Listing all the reviews in the Reviews Tab
//        WebElement reviewContent = driver
//                .findElement(By.cssSelector("#customer-reviews > div.block-content > ol > li:nth-child(1) > " +
//                        "div.review-content"));
//        log.info("The Review Content is {}", reviewContent.getText());

        // Get all the elements available with tag name 'li'
        WebElement reviewOrderedList = driver
                .findElement(By.cssSelector("#customer-reviews > div.block-content > ol"));
        List<WebElement> listElements = reviewOrderedList.findElements(By.tagName("li"));

        // filter the element for review-content
        for (WebElement element : listElements) {
            WebElement divContent = element
                    .findElement(By.cssSelector("div.review-content"));
//            log.info("review content is {}", divContent.getText());

            WebElement divRating = element
                    .findElement(By.cssSelector("div.rating-result"));
            log.info("review rating is {} \t review is {}", divRating.getText(), divContent.getText());
        }
        assertEquals(listElements.size(), 3);
    }
}
