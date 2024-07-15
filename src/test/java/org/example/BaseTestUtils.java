package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTestUtils {

    static void tearDown(WebDriver driver) {
        WebElement signOutToggleButton = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
        signOutToggleButton.click();

        WebElement signOut = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        signOut.click();


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {

                    if (driver.getCurrentUrl()
                            .contains("https://magento.softwaretestingboard.com" +
                                    "/customer/account/logoutSuccess/")) {
                        System.out.println("successfully logged out");
                        return true;
                    } else
                        return false;
                });
        driver.quit();
    }
}
