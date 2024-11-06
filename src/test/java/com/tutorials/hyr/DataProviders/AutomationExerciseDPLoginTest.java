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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Objects;

@Listeners({CustomListener.class})
public class AutomationExerciseDPLoginTest extends BaseUtilTest {

    private final Logger log = LogManager.getLogger(AutomationExerciseDPLoginTest.class);

    @Test(dataProvider = "automationTestDP", dataProviderClass = AutomationExerciseDataProvider.class)
    public void loginToYourAccountTest(String email, String password) {

        log.info("Step 1: Launching AutomationExercise site");
        WebDriver driver = new ChromeDriver();
        
        //Create WebDriver for the Browser(chrome) here .like above
        //because while running parallel the browser should be created each time

        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");

        log.info("Step 2: Clicking SignIn Button");
        WebElement signUpElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpElement.click();

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
            WebElement errorMessageElement = driver.findElement(By
                    .xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
            String errorMessage = errorMessageElement.getText();
            if (!Objects.equals(errorMessage, "")) {
                log.info("Login Failed:{}", errorMessageElement.getText());
            }
        } catch (NoSuchElementException e) {
            log.info("");
        }

        driver.close();
    }
}
