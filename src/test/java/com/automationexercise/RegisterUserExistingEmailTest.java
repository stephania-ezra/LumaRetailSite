package com.automationexercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class RegisterUserExistingEmailTest {

    public final Logger log = LogManager.getLogger(RegisterUserExistingEmailTest.class);
    public WebDriver driver = new ChromeDriver();
    BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        but.logoutAutomationExercise(driver);
    }

    @Test(priority = 1)
    public void signUp() {
        driver.manage().window().maximize();

        //Launch Browser
        log.info("executing step 2");
        driver.get("http://automationexercise.com");

        //verifying home page is visible successfully
        log.info("executing step 3");
        assertEquals(driver.getTitle(), "Automation Exercise");

        //Click on Signup / Login Button
        log.info("executing step 4");
        WebElement signUpOrLogin = driver.findElement(xpath("//*[@id=\"header\"]/div/div/div/" +
                "div[2]/div/ul/li[4]/a"));
        signUpOrLogin.click();

        //Verify 'New User Signup!' is visible
        log.info("executing step 5");
        WebElement newUserSignup = driver.findElement(xpath("//*[@id=\"form\"]/" +
                "div/div/div[3]/div/h2"));
        assertEquals(newUserSignup.getText(), "New User Signup!");

        //Enter name and email address
        log.info("executing step 6");
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("testing");

        WebElement emailAddress = driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > " +
                "div > form > input[type=email]:nth-child(3)"));
        emailAddress.sendKeys("collins.einstein@gmail.com");

        //Click 'Signup' button
        log.info("executing step 7");
        WebElement signupElement = driver.findElement(xpath("//*[@id=\"form\"]" +
                "/div/div" +
                "/div[3]/div/form/button"));
        signupElement.click();

        //Verify error 'Email Address already exist!' is visible
        log.info("executing step 8");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        log.info("errorMessage {}", errorMessage.getText());
        assertEquals(errorMessage.getText(), "Email Address already exist!");
    }
}