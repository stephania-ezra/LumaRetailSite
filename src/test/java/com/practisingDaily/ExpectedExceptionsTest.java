package com.practisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExpectedExceptionsTest {

    public final Logger log = LogManager.getLogger(ExpectedExceptionsTest.class);

    @Test(expectedExceptions = {NoSuchElementException.class, ThreadTimeoutException.class})
    public void expectedExceptions() {

        log.info("Testing Expected Exceptions");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // knowingly raising NoSuchElementException
        // idElement is not available , assuming and sending to check the functionality

        WebElement idElement = driver.findElement(By.id("abcd"));
        idElement.click();

        driver.quit();
    }
}
