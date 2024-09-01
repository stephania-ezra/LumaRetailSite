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
public class LoginUserWithDeleteTest {

    public final Logger log = LogManager.getLogger(LoginUserWithDeleteTest.class);
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
    public void step1() {
        log.info("executing step 1");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void step2() {
        log.info("executing step 2");
        driver.get("http://automationexercise.com");
    }

    @Test(priority = 3)
    public void step3() {
        log.info("executing step 3");
        assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @Test(priority = 4)
    public void step4() {
        log.info("executing step 4");
        //Click on Signup / Login Button
        WebElement signUpOrLogin = driver.findElement(xpath("//*[@id=\"header\"]/div/div/div/" +
                "div[2]/div/ul/li[4]/a"));
        signUpOrLogin.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        WebElement loginToYourAccountElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        assertEquals(loginToYourAccountElement.getText(), "Login to your account");
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");

        WebElement emailAddressElement = driver.findElement(By.name("email"));
        emailAddressElement.sendKeys("collins.einstein@gmail.com");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("testing123");
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        WebElement loginButtonElement = driver.findElement(By
                .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
        loginButtonElement.click();
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");
        WebElement loginAsElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        assertEquals(loginAsElement.getText(), "Logged in as testing");
    }

    @Test(priority = 9)
    void step9() {
        // 17. Click 'Delete Account' button
        log.info("executing step 9");
        WebElement deleteButtonElement = driver.findElement(By
                .xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteButtonElement.click();
    }

    @Test(priority = 10)
    void step10() {
        // 10. Verify that 'ACCOUNT DELETED!' is visible
        log.info("executing step 10");
        WebElement deleteVerifyTextElement = driver.findElement(By
                .xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        assertEquals(deleteVerifyTextElement.getText().toUpperCase(), "ACCOUNT DELETED!");
    }
}