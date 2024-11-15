package com.tutorials.hyr.DataProviders;

import com.practisingDaily.LoginDPTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExcelDataSupplierTest {

    private final Logger log = LogManager.getLogger(ExcelDataSupplierTest.class);

    @Test(dataProvider = "loginDetailsData", dataProviderClass = LoginDPTest.class)
    void loginToYourAccountTest(String email, String password) throws InterruptedException {

        log.info("Step 1: Launching AutomationExercise site");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();

        log.info("Step 2: Clicking SignIn Button");
        WebElement signInElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signInElement.click();

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
            driver.wait(3);

        } catch (NoSuchElementException e) {
            log.info("Login failed");
        }
        driver.quit();
    }

   /* //creating Data Provider Method
    @dataProvider
    public Object[][] loginDetails() {
        Object[][] data = new Object[2][2];
        data[0][0] = "collins.einstein@gmail.com";
        data[0][1] = "testing123";

        data[1][0] = "admin@gmail.com";
        data[1][1] = "admin111";

        return data;
    }*/

}
