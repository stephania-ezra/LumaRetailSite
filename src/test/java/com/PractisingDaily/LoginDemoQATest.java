package com.PractisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginDemoQATest {

    public static Logger log = LogManager.getLogger(LoginDemoQATest.class);

    @Test(priority = 0)
    public void registerUSerDemoQA() throws InterruptedException {
        log.info("Step 1: Setting Login");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/register");
        driver.manage().window().maximize();

        WebElement FirstNameElement = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        FirstNameElement.sendKeys("Stella");

        WebElement LastNameElement = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        LastNameElement.sendKeys("Ruby");

        WebElement UserNameElement = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        UserNameElement.sendKeys("Stell");

        WebElement PasswordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        PasswordElement.sendKeys("123stell@");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(5000);

        WebElement NotARobotElement = driver.findElement(By
                .cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border"));
        Thread.sleep(5);
        NotARobotElement.click();

        WebElement RegisterButtonElement = driver.findElement(By.cssSelector("#register"));
        RegisterButtonElement.click();

        driver.quit();
    }
}

