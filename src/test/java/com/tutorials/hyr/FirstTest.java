package com.tutorials.hyr;

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

public class FirstTest extends BaseUtilTest {
    public final Logger log = LogManager.getLogger(FirstTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        //BaseUtilTest btu = new BaseUtilTest();
        but.tearDown(driver);
    }

    @Test

    //Displaying the title in HYR tutorials page
    public void TestGoogle() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/?gws_rd=cr");

        WebElement tutorialElement = driver.findElement(By.name("q"));
        tutorialElement.sendKeys("HYR Tutorials", Keys.ENTER);
        log.info(driver.getTitle());
        // using assertions
        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search", "Title Mismatch");
        but.stopTheFlow(3);
    }

    @Test
    //Typing HYR tutorials in facebook email address box
    public void TestFacebook() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement emailAddressElement = driver.findElement(By.name("email"));
        emailAddressElement.sendKeys("HYR Tutorials", Keys.ENTER);
        log.info(driver.getTitle());
        but.stopTheFlow(3);
    }
}
