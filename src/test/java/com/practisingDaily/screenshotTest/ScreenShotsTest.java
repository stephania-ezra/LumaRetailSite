package com.practisingDaily.screenshotTest;

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
public class ScreenShotsTest extends BaseUtilTest {

    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(ScreenShotsTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test
    public void googleTest() {

        log.info("First Test: Google Test");
        driver.get("https://www.google.co.in/?gws_rd=cr");
        driver.manage().window().maximize();

        WebElement inputHYRElement = driver.findElement(By.name("q"));
        inputHYRElement.sendKeys("HYR Tutorials", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search1", "Title Mismatch");
        but.stopTheFlow(3);
    }

    @Test(priority = 1)
    public void orangeHRMTest() {
        log.info("OrangeHRMTest");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        but.stopTheFlow(3);
        WebElement userNameElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/" +
                        "div[2]/form/div[1]/div/div[2]/input"));
        userNameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/" +
                        "div[2]/form/div[2]/div/div[2]/input"));
        passwordElement.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By
                .cssSelector("#app > div.orangehrm-login-layout > div > " +
                        "div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > " +
                        "form > div.oxd-form-actions.orangehrm-login-action > button"));
        loginButton.click();
    }
}
