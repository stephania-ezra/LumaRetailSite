package org.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LumaLoginTest {

    private final Logger log = LogManager.getLogger(LumaLoginTest.class);
    public WebDriver driver = new ChromeDriver();


    public void login() {

        log.info("running login from {}", Thread.currentThread().threadId());
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
                    WebElement welcomeUser = d
                            .findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));

                    if (welcomeUser.getText().equalsIgnoreCase("Welcome, Stephania Collins!")) {
                        log.info("Logged In {}", welcomeUser.getText());
                        return true;
                    } else {
                        log.info(welcomeUser.getText());
                        return false;
                    }
                });
        assertTrue(result);
    }
}
