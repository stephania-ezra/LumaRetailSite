package com.practisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.List;

@Listeners({CustomListener.class})
public class PetStoreLoginDataTest extends BaseUtilTest {

    public Logger log = LogManager.getLogger(PetStoreLoginDataTest.class);
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

    @Test
    public void launchUrl() {
        log.info("Step 1 : Launching the Website");
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void fishTabDisplay() {
        log.info("Step 2 : Displaying Fish Tab");
        WebElement FishElement = driver.findElement(By
                .xpath("//*[@id=\"SidebarContent\"]/a[1]/img"));
        FishElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> trList = tableElement.findElements(By.tagName("tr"));
        log.info("Total Number of Rows :{}", trList.size());

        int i = 0;
        for (WebElement tr : trList) {
            i++;
            if (i == 1)
                continue;

            log.info("Displaying Fish List:{}", tr.getText());
            WebElement aLink = tr.findElement(By.tagName("a"));
            aLink.click();
            but.stopTheFlow(3);

            driver.navigate().back();
        }
    }

    @Ignore
    @Test(priority = 2)
    public void dogsTabDisplay() {
        WebElement DogsElement = driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[2]/img"));
        DogsElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            log.info(row.getText());
        }
    }

    @Ignore
    @Test(priority = 3)
    public void reptilesTabDisplay() {
        WebElement reptilesElement = driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[3]/img"));
        reptilesElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            log.info(row.getText());
        }
    }

    @Ignore
    @Test(priority = 4)
    public void catsTabDisplay() {
        WebElement catsElement = driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[4]/img"));
        catsElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            log.info(row.getText());
        }
    }

    @Ignore
    @Test(priority = 5)
    public void birdsTabDisplay() {
        WebElement birdsElement = driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[5]/img"));
        birdsElement.click();

        WebElement categoryElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2"));
        log.info(categoryElement.getText());

        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            log.info(row.getText());
        }
    }

    @Ignore
    @Test(priority = 6)
    public void returnToMainMenu() {
        WebElement returnMainMenu = driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
        returnMainMenu.click();
    }
}
