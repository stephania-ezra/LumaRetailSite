package com.practisingDaily.dataProvider;

import com.practisingDaily.SauceDemoExcelDataTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class SauceDemoBeginTest {

    public final Logger log = LogManager.getLogger(SauceDemoBeginTest.class);

    @Test(dataProvider = "sauceDemoExcelData", dataProviderClass = SauceDemoExcelDataTest.class)
    public void dataProviderBasic(String username, String password) {

        log.info("Learning Data Provider");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebElement userNameElement = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        userNameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordElement.sendKeys(password);

        WebElement loginElement = driver.findElement(By.cssSelector("#login-button"));
        loginElement.click();

        try {
            WebElement errorMessageElement = driver.findElement(By
                    .xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            String errorMessage = errorMessageElement.getText();
            assertEquals(errorMessage, "\"Epic sadface: Sorry, this user has been" +
                    " locked out.");
            if (!Objects.equals(errorMessage, "")) {
                log.info("Error Message:{}", errorMessage);
            }
        } catch (NoSuchElementException e) {
            log.info("");
        }
        driver.quit();
    }

    //indices concept
    //@dataProvider(indices = {0, 2, 4, 6})
    @DataProvider(parallel = true)
    public Object[][] swagData() {
        Object[][] data = new Object[7][2];

        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        data[1][0] = "secret_sauce";
        data[1][1] = "secret_sauce";

        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        data[4][0] = "performance_glitch_user";
        data[4][1] = "secret_sauce";

        data[5][0] = "visual_user";
        data[5][1] = "secret_sauce";

        data[6][0] = "standard_user";
        data[6][1] = "test123";

        return data;
    }
}
