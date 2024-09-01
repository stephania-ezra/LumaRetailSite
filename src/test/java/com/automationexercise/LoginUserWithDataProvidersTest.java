package com.automationexercise;

import com.automationexercise.dataproviders.TestAutomationExerciseDataSupplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginUserWithDataProvidersTest {

    private final Logger Log = LogManager.getLogger(LoginUserWithDataProvidersTest.class);
    public WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "getLoginDetails", dataProviderClass = TestAutomationExerciseDataSupplier.class)
    public void automationExerciseLogin(String emailId, String password) {
        
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");

        //Signup/Login

        WebElement signUporLoginElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUporLoginElement.click();

        //Email Address
        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys(emailId);

        //password
        WebElement passwordElement = driver.findElement(By.name("pass"));
        passwordElement.sendKeys(password);

        //Login Button
        WebElement logInButton = driver.findElement(By
                .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
        logInButton.click();

        driver.quit();
    }
}
