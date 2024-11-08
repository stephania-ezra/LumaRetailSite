package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LearningDataProviderTest extends BaseUtilTest {

    private final Logger log = LogManager.getLogger(LearningDataProviderTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @Test(dataProvider = "loginDetails")
    public void getLoginDetails(String username, String password) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        but.stopTheFlow(5);

        WebElement userNameElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        userNameElement.sendKeys(username);
        but.stopTheFlow(3);

        WebElement passwordElement = driver.findElement(By
                .xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        passwordElement.sendKeys(password);
        but.stopTheFlow(3);

        WebElement loginElement = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div >" +
                " div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form >" +
                " div.oxd-form-actions.orangehrm-login-action > button"));
        loginElement.click();
        but.stopTheFlow(3);
        but.tearDown(driver);
    }

    //creating Data Provider Method
    @DataProvider(parallel = true)
    public String[][] loginDetails() {
        //pls check the column values while defining the size
        //2 columns here so specify the column as 2
        String[][] data = new String[5][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";

        data[1][0] = "stella";
        data[1][1] = "admin111";

        data[2][0] = "Vincy";
        data[2][1] = "Stella123";

        data[3][0] = "bert";
        data[3][1] = "beauty12";

        data[4][0] = "iopwer";
        data[4][1] = "dirty12";

        return data;
    }
}
