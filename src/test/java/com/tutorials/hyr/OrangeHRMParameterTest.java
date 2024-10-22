package com.tutorials.hyr;

// import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class OrangeHRMParameterTest extends BaseUtilTest {
    private final Logger log = LogManager.getLogger(OrangeHRMParameterTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    WebDriver driver;

    @BeforeClass
    @Parameters("browserName")
    public void setDriver(ITestContext context, @Optional("chrome") String browserName) {
        //Launching different Browsers
        switch (browserName.toLowerCase()) { //edge
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        log.info("Setting Context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        but.tearDown(driver);
    }

    @Test
    @Parameters("url")
    public void LaunchApp(@Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) {
        driver.manage().window().maximize();
        driver.get(url);
        but.stopTheFlow(3);
    }

    @Test(priority = 1)
    @Parameters({"username", "password"})
    public void EnterLoginDetails(String username, @Optional("admin123") String password) {
        WebElement userNameElement = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form" +
                        "/div[1]/div/div[2]/input"));
        userNameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form" +
                        "/div[2]/div/div[2]/input"));
        passwordElement.sendKeys(password);

        WebElement authLoginElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/" +
                "div/div[2]/div[2]/form/div[3]/button"));
        authLoginElement.click();
        but.stopTheFlow(3);
    }

    @Test(priority = 2)
    public void VerifyLogin() {
        // Verifying Login Details
        WebElement loggedInUser = driver.findElement(By
                .xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        //WebElement loggedInUser = driver.findElement(By
        //.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p"));
        assertTrue(loggedInUser.isDisplayed());
        log.info("LoggedIn User: {}", loggedInUser.getText());
        but.stopTheFlow(3);
    }

    @Test(priority = 3)
    public void NavigateToMyInfo() {

        assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
                , driver.getCurrentUrl());
        but.stopTheFlow(5);
        //Clicking MyInfo Tab
        WebElement myInfoElement = driver.findElement(By.
                xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]"));
        myInfoElement.click();
        log.info("MyInfo Tab is Clicked");
        but.stopTheFlow(3);
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
}
