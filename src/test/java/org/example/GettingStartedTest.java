package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GettingStartedTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void formSubmitTest() {


        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.getTitle();
        /*Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> revealed.isDisplayed());*/
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        WebElement submitButton = driver
                .findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        textArea.sendKeys("GettingStarted");
        submitButton.click();

        WebElement result = driver.findElement(By.xpath("/html/body/main/div/div[1]/div/h1"));
        assertEquals(result.getText(), "Form submitted");
    }
}
