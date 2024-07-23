package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MoreInformationTest {

    private final Logger log = LogManager.getLogger(MoreInformationTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    private final WebDriver driver = new ChromeDriver();

    @BeforeClass
    void setUp() {
        driver.manage().window().maximize();
    }

    @AfterClass
    void tearDown() {
        but.tearDown(driver);
    }

    @Test
    public void moreInformation() {

        // get More Information details for Montana Wind Jacket
        driver.get("https://magento.softwaretestingboard.com/montana-wind-jacket.html");
        log.info("Montana Wind Jacket is displayed");
        but.stopTheFlow(5);

        // Click MoreInformation Tab
        WebElement moreInformation = driver.findElement(By.id("tab-label-additional-title"));
        moreInformation.click();
        but.stopTheFlow(5);

        // Get all the elements available with tag name 'tbody'
        WebElement tableBody = driver
                .findElement(By.cssSelector("#product-attribute-specs-table > tbody"));
        List<WebElement> trElements = tableBody.findElements(By.tagName("tr"));

        WebElement td = trElements.getLast();
        log.info("more info.climate is {}", td.getText());

//        for (WebElement element : trElements) {
//            WebElement td = element.findElement(By.tagName("td"));
//            if (td.getAttribute("data-th").equalsIgnoreCase("climate"))
//                log.info("more info.climate is {}", td.getText());
//        }
        assertEquals(trElements.size(), 4);
    }
}