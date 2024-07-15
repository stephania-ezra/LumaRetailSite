package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LumaLoginTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {

        driver.get("https://magento.softwaretestingboard.com/");
        assertEquals(driver.getTitle(), "Home Page");

        WebElement signInElement = driver
                .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        signInElement.click();

        //finding customerLogin
        WebElement customerLogin = driver
                .findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span"));

        //checking "Customer Login"
        assertEquals(customerLogin.getText(), "Customer Login");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(System.getenv("luma.username"));

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys(System.getenv("luma.password"));

        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();


        boolean result = new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    WebElement welcomeUser = driver
                            .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));

                    if (welcomeUser.getText().equalsIgnoreCase("Welcome, Stephania Collins!")) {
                        System.out.println("working " + welcomeUser.getText());
                        return true;
                    } else {
                        System.out.println(welcomeUser.getText());
                        return false;
                    }
                });
        assertTrue(result);
    }
}
