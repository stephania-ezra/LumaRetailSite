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
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class OrangeHRMEnableTest extends BaseUtilTest {
    private final Logger log = LogManager.getLogger(OrangeHRMEnableTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("Setting Context");
        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test(priority = 0)
    @Parameters("url")
    public void LaunchApp(@Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) {
        driver.get(url);
    }

    @Test(priority = 1)
    @Parameters({"username", "password"})
    public void EnterLoginDetails(String username, @Optional("admin123") String password) {
        but.stopTheFlow(5);
        WebElement userNameElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/" +
                "div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        userNameElement.sendKeys(username);
        but.stopTheFlow(5);

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form" +
                        "/div[2]/div/div[2]/input"));
        passwordElement.sendKeys(password);

        WebElement authLoginElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/" +
                "div/div[2]/div[2]/form/div[3]/button"));
        authLoginElement.click();
        but.stopTheFlow(5);
    }

    @Test(priority = 2)
    public void VerifyLogin() {
        // Verifying Login Details
        but.stopTheFlow(5);
        WebElement loggedInUser = driver.findElement(By
                .xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        but.stopTheFlow(5);
        assertTrue(loggedInUser.isDisplayed());
        log.info("LoggedIn User: {}", loggedInUser.getText());
        but.stopTheFlow(5);
    }

    @Test(priority = 3)
    public void NavigateToMyInfo() {
        but.stopTheFlow(5);
        assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
                , driver.getCurrentUrl());
        but.stopTheFlow(5);
        //Clicking MyInfo Tab
        WebElement myInfoElement = driver.findElement(By.
                xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]"));
        myInfoElement.click();
        log.info("MyInfo Tab is Clicked");
        but.stopTheFlow(5);
    }

    @Test(priority = 4)
    public void VerifyMyInfo() {
        //Verifying the display of My Information details

        WebElement verifyMyInfoElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div[2]"));
        String verificationMyInfo = verifyMyInfoElement.getText();
        if (verificationMyInfo != null) {
            log.info("Displaying My Information details\t" + "verificationInfo: {} ",
                    verifyMyInfoElement.getText());
        }
        but.stopTheFlow(3);
    }

    @Test(priority = 5)
    @Parameters({"googleUrl", "tutorialName"})
    public void TestGoogle(String googleUrl, String tutorialName) {
        driver.manage().window().maximize();
        driver.get(googleUrl);

        WebElement tutorialElement = driver.findElement(By.name("q"));
        tutorialElement.sendKeys(tutorialName, Keys.ENTER);
        log.info(driver.getTitle());
        // using assertions
        Assert.assertEquals(driver.getTitle(), "HYR Tutorials - Google Search", "Title Mismatch");
        but.stopTheFlow(3);
    }

    @Test(priority = 6)
    @Parameters({"facebookUrl", "tutorialName"})
    //Typing HYR tutorials in facebook email address box
    public void TestFacebook(String facebookUrl, String tutorialName) {
        driver.manage().window().maximize();
        driver.get(facebookUrl);

        WebElement emailAddressElement = driver.findElement(By.name("email"));
        emailAddressElement.sendKeys(tutorialName, Keys.ENTER);
        log.info(driver.getTitle());
        but.stopTheFlow(3);
    }
}
