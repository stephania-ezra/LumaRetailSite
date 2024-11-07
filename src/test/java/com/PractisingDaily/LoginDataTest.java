package com.PractisingDaily;

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

public class LoginDataTest extends BaseUtilTest {

    public Logger log = LogManager.getLogger(LoginDataTest.class);
    public WebDriver driver = new ChromeDriver();
    public BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("setting Context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test(priority = 0)
    public void launchUrl() {
        log.info("Step 1 : Launching the Website");
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.manage().window().maximize();

        WebElement FishElement = driver.findElement(By
                .xpath("//*[@id=\"SidebarContent\"]/a[1]/img"));
        FishElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            log.info(row.getText());
        }
    }
}
