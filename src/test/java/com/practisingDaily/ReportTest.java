package com.practisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})
public class ReportTest extends BaseUtilTest {
    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(ReportTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setup(ITestContext context) {
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void teardown() {
        but.tearDown(driver);
    }

    @Test
    public void googleTest() {

        log.info("First Test: Google Test");
        driver.get("https://www.google.co.in/?gws_rd=cr");
        but.stopTheFlow(3);
        WebElement inputHYRElement = driver.findElement(By.name("q"));
        inputHYRElement.sendKeys("HYR Tutorials", Keys.ENTER);
        //purposely failing
        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search1", "Title Mismatch");
    }

    @Test(priority = 1)
    public void orangeHRMTest() throws InterruptedException {
        log.info("Second Test: OrangeHRMTest");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        but.stopTheFlow(3);

        WebElement userNameElement = driver.findElement(By.name("username"));
        userNameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        but.stopTheFlow(3);
        WebElement loggedInUser = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        String loggedUser = loggedInUser.getText();
        if (loggedUser != null) {
            log.info("Logged in User is :{} ", loggedUser);
        }
    }
}
