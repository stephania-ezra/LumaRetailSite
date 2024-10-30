package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({CustomListener.class})
public class LearningDataProviderTest extends BaseUtilTest {
    private final Logger log = LogManager.getLogger(LearningDataProviderTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }


    @Test(priority = 0)
    public void LaunchBrowser() {

        log.info("LAUNCHING URL");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        but.stopTheFlow(3);
    }

    @Test(priority = 1, dataProvider = "loginDataDetails")
    public void GetLoginDetails(String Username, String Password) {

        log.info("GETTING LOGIN DETAILS");
        WebElement UsernameElement = driver.findElement(By.name("username"));
        UsernameElement.sendKeys("Username");

        WebElement PasswordElement = driver.findElement(By.name("password"));
        PasswordElement.sendKeys("Password");

        WebElement LoginElement = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div >" +
                " div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form >" +
                " div.oxd-form-actions.orangehrm-login-action > button"));
        LoginElement.click();
        but.stopTheFlow(7);
    }

    @Test(priority = 2)
    public void CheckLoggedInUser() {

        log.info("CHECKING LOGGEDIN USER");
        WebElement LoggedInUserElement = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/" +
                "header/div[1]/div[3]/ul/li/span/p"));
        Assert.assertTrue(LoggedInUserElement.isDisplayed());
        log.info("User name: {}", LoggedInUserElement.getText());
        but.stopTheFlow(5);
    }

    //creating Data Provider Method
    @DataProvider(name = "loginDataDetails")
    public Object[][] loginDetails() {
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";

        data[1][0] = "Admin";
        data[1][1] = "admin111";

        return data;
    }
}
