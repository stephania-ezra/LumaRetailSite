package org.luma.user.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.dataproviders.TestExcelDataSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LumaLoginPracticeTest {

    public final Logger log = LogManager.getLogger(LumaLoginPracticeTest.class);


    @Test(dataProvider = "getLoginDetails", dataProviderClass = TestExcelDataSupplier.class)
    public void lumaLogin(String emailId, String password) {
        log.info("running Login Page");

        log.debug("emailId {} ", emailId);
        log.debug("password {} ", password);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement signInElement = driver.findElement(By.xpath("/html/body/div[2]/header/" +
                "div[1]/div/ul/li[2]/a"));
        signInElement.click();

        driver.get("https://magento.softwaretestingboard.com/customer" +
                "/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        assertEquals(driver.getTitle(), "Customer Login");

        //email
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(emailId);

        //password
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys(password);

        //signin
        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();
        log.info("successful login");
        driver.quit();
    }
}
