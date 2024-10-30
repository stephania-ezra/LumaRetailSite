package com.automationexercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class RegisterUserTest {

    public final Logger log = LogManager.getLogger(RegisterUserTest.class);
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
                "/div/div/div[3]/div/form/button"));
        signupElement.click();
    }

    @Test(priority = 2)
    public void accountInformation() {
        log.info("executing step 8");
        WebElement accountElement = driver.findElement(xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
        log.info("accountElement {} ", accountElement.getText());

        //changing the lowercase letters to Uppercase letters
        assertEquals(accountElement.getText().toUpperCase(), "ENTER ACCOUNT INFORMATION");

        // radio button Mr and Mrs for Title
        log.info("executing step 9");
        WebElement mrRadio = driver.findElement(By
                .xpath("//*[@id=\"id_gender1\"]"));
        log.info("Mr Radio button before clicking {}", mrRadio.isSelected());
        mrRadio.click();
        log.info("Mr Radio button is clicked {}", mrRadio.isSelected());
        assertTrue(mrRadio.isSelected());

        WebElement nameElement = driver.findElement(By.id("name"));
        WebElement emailElement = driver.findElement(By.id("email"));

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("testing123");

        assertEquals(nameElement.getAttribute("value"), "testing");
        assertEquals(emailElement.getAttribute("value"), "collins.einstein@gmail.com");

        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByValue("10");

        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("1");

        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1987");

        log.info("executing step 10");
        WebElement newsLetter = driver.findElement(By.
                xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label"));
        newsLetter.click();

        log.info("executing step 11");
        WebElement specialOffers = driver.findElement(By.
                xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label"));
        specialOffers.click();
    }

    @Test(priority = 3)
    public void addressInformation() {
        log.info("executing step 12");

        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Stephania");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Collins");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("CacronMacron");

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Gandhi Street");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Tnagar");

        //country
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("India");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("TamilNadu");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Chennai");

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("600100");

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("9988776655");

        log.info("executing step 13");
        WebElement createAccountButton = driver.findElement(By.
                xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccountButton.click();

        log.info("executing step 14");
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        log.info("successMessage {}", successMessage.getText());
        assertEquals(successMessage.getText().toUpperCase(), "ACCOUNT CREATED!");

        // click continue button
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton.click();
        but.stopTheFlow(3);
    }
}