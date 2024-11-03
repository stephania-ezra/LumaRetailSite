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
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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
        WebElement SignInElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        SignInElement.click();
        but.stopTheFlow(3);

        log.info("Step 3: Clicking LoginToYourAccount");
        WebElement EmailAddressElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        EmailAddressElement.sendKeys(email);

        WebElement PasswordElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        PasswordElement.sendKeys(password);

        WebElement LoginButtonElement = driver.findElement(By
                .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
        LoginButtonElement.click();
        but.stopTheFlow(3);

        WebElement userNameElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
        log.info(userNameElement);

        if (userNameElement != null) {
            assertTrue(userNameElement.isDisplayed());
        } else
            assertFalse(false);

        /*log.info("Step 4: Logout from the user");
        WebElement LogOutElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        LogOutElement.click();
        but.stopTheFlow(3);*/

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
