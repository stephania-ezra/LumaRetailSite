package com.PractisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeOutExceptionTest {

    public final Logger log = LogManager.getLogger(TimeOutExceptionTest.class);

    //Checking the webpage to be loaded  within 2 seconds
    // @Test(timeOut = 2000)
    @Test
    public void timeOutTest() {
        log.info("Testing TimeOut Exception");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //checking URL of letcode with Kaushik :)
        driver.get("https://letcode.in/");
        driver.quit();
    }
}
