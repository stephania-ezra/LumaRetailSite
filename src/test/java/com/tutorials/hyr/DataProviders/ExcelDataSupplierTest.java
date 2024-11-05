package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class ExcelDataSupplierTest extends BaseUtilTest {

    public final WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(ExcelDataSupplierTest.class);
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

    @Test(priority = 0)
    public void AutomationExerciseLaunch() {
        log.info("Step 1: Launching AutomationExercise site");
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test(priority = 1, dataProvider = "loginDetails")
    void LoginToYourAccountTest(String email, String password) {

        log.info("Step 2: Clicking SignIn Button");
        WebElement signInElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signInElement.click();
        but.stopTheFlow(3);

        log.info("Step 3: Clicking LoginToYourAccount");
        WebElement emailAddressElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        emailAddressElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        passwordElement.sendKeys(password);

        WebElement loginButtonElement = driver.findElement(By
                .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
        loginButtonElement.click();
        but.stopTheFlow(3);

        try {
            WebElement userNameElement = driver.findElement(By
                    .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
            assertTrue(userNameElement.isDisplayed());
            assertEquals(userNameElement.getText()
                    .toLowerCase(), "thilothima", "UserCredentials not Valid");

            log.info("Step 4: Logout from the user");
            WebElement LogOutElement = driver.findElement(By
                    .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
            LogOutElement.click();
            but.stopTheFlow(3);

        } catch (NoSuchElementException e) {
            log.info("Login failed");
        }
    }

    //creating Data Provider Method
    @DataProvider
    public Object[][] loginDetails() {
        Object[][] data = new Object[2][2];
        data[0][0] = "collins.einstein@gmail.com";
        data[0][1] = "testing123";

        data[1][0] = "admin@gmail.com";
        data[1][1] = "admin111";

        return data;
    }
}
