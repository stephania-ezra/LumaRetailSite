package com.automationexercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class ContactUsFormTest {

    public final Logger log = LogManager.getLogger(ContactUsFormTest.class);
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
        //Click on 'Contact Us' button
        WebElement contactUsButtonElement = driver.findElement(By
                .cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a"));
        contactUsButtonElement.click();
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        //Verify 'GET IN TOUCH' is visible
        WebElement getInTouchElement = driver.findElement(By
                .xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        assertEquals(getInTouchElement.getText(), "GET IN TOUCH");
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");
        //Enter name, email, subject and message

        WebElement nameElement = driver.findElement(By.name("name"));
        nameElement.sendKeys("UzhagaAzhagi");

        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys("collins.einstein@gmail.com");

        WebElement subjectElement = driver.findElement(By.name("subject"));
        subjectElement.sendKeys("Learning Automation");

        WebElement messageElement = driver.findElement(By.id("message"));
        messageElement.sendKeys("It is known that I am a very experienced automation tester");
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        //upload file
        WebElement chooseFileButtonElement = driver.findElement(By
                .xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        chooseFileButtonElement.sendKeys("C:\\Users\\steph\\OneDrive\\Desktop\\testing.txt");
    }

    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");

        //Click 'Submit' button
        WebElement submitButtonElement = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
        submitButtonElement.click();
    }

    @Test(priority = 9)
    public void step9() {
        log.info("executing step 9");

        //Handling pop ups in selenium
        //alert messages
        Alert alert = driver.switchTo().alert();
        log.info("Press OK to proceed!");

        String text = alert.getText();
        if (text.equals("Press OK to proceed!")) {
            log.info("correct alert message");
        } else {
            log.info("Incorrect alert message");
        }

        //clicking on OK button
        alert.accept();
        //alert.dismiss(); for clicking no
    }

    @Test(priority = 10)
    public void step10() {
        log.info("executing step 10");
        WebElement successMessageElement = driver.findElement(By
                .xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));

        //assertEquals(successMessageElement.getText(), "'Success! Your details have been submitted successfully.'");
        assertTrue(successMessageElement.isDisplayed());
    }

    @Test(priority = 11)
    public void step11() {
        log.info("executing step 11");

        //Click 'Home' button and verify that landed to home page successfully
        WebElement homeButtonElement = driver.findElement(By.cssSelector("#form-section > a > span"));
        homeButtonElement.click();

        assertEquals(driver.getTitle(), "Automation Exercise");
    }
}

