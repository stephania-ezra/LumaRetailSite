package com.practisingDaily.dataProvider;

import com.practisingDaily.LoginDPTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Objects;

public class LoginDetailsDPTest {
    private final Logger log = LogManager.getLogger("LoginDetailsDPTest.class");

    @Test(dataProvider = "loginDetailsData", dataProviderClass = LoginDPTest.class)
    public void login(String email, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();

        WebElement signUpOrLoginElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpOrLoginElement.click();

        WebElement emailAddressElement = driver.findElement(By.name("email"));
        emailAddressElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        WebElement loginElement = driver.findElement(By
                .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
        loginElement.click();

        try {
            WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
            String errorMessage = errorMessageElement.getText();
            if (!Objects.equals(errorMessage, "")) {
                log.info("Error Message:{}", errorMessage);
            }
        } catch (
                NoSuchElementException e) {
            log.info("");
        }

        WebElement logOutElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logOutElement.click();

        driver.close();
    }

}
