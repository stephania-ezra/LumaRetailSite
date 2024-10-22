package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})

public class OrangeHrmTest extends BaseUtilTest {

    private final Logger Log = LogManager.getLogger(OrangeHrmTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        Log.info("Setting Context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void teardown() {
        but.tearDown(driver);
    }

    @Test(priority = 0)
    public void LaunchApp() {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log.info("Successfully Logged into the Application");
        but.stopTheFlow(3);
    }

    @Test(priority = 1)
    public void EnterLoginDetails() {

//        WebElement userNameElement = driver.findElement(By.name("username"));
//        userNameElement.sendKeys("Admin");

        WebElement userNameElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/" +
                "div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        userNameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        WebElement authLoginElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/" +
                "div/div[2]/div[2]/form/div[3]/button"));
        authLoginElement.click();
        log.info("LoginDetails Entered");
        but.stopTheFlow(3);
    }

    @Test(priority = 3)
    public void NavigateToMyInfo() {
        //Clicking MyInfo Tab

        WebElement myInfoElement = driver.findElement(By.
                xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
        myInfoElement.click();
        log.info("MyInfo Tab is Clicked");
        but.stopTheFlow(3);
    }

    @Test(priority = 4)
    public void VerifyMyInfo() {
        //Verifying the display of My Information details

        WebElement verifyMyInfoElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div"));
        String verificationMyInfo = verifyMyInfoElement.getText();
        if (verificationMyInfo != null) {
            log.info("Displaying My Information details\t" + "verificationInfo: {} ",
                    verifyMyInfoElement.getText());
        }
        but.stopTheFlow(3);
    }

    @Test(priority = 2)
    public void VerifyLogin() {
        // Verifying Login Details
        WebElement loggedInUser = driver.findElement(By
                .xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        //WebElement loggedInUser = driver.findElement(By
        //.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        Log.info(loggedInUser.isDisplayed());
        log.info("LoggedIn User: {}", loggedInUser.getText());
        but.stopTheFlow(3);
    }
}
