package com.practisingDaily;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class InvocationCountTest {

    public final Logger log = LogManager.getLogger(InvocationCountTest.class);
    BaseUtilTest but = new BaseUtilTest();

    //@Test(invocationCount = 3, invocationTimeOut = 10000)
    @Test(invocationCount = 4, threadPoolSize = 2)
    //10 seconds = 10000milli seconds , we need to specify in milliseconds
    public void getRandomUser() throws InterruptedException {

        //I need to have the details for multiple users
        // so for loop can be used . it works :)
        //for (int i = 0; i < 2; i++) {

        log.info("Getting the Users in Random");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://randomuser.me/");

        WebElement ulElement = driver.findElement(By.xpath("//*[@id=\"values_list\"]"));

        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        log.info("liElements.size {}", liElements.size());

        for (WebElement liElement : liElements) {
            //when the name not displayed , first hover the element and get the attribute value
            but.hoverTheElement(driver, liElement);
            log.info("hovers {} ", liElement.getAttribute("data-value"));
        }
        driver.quit();
        //}
    }
}

