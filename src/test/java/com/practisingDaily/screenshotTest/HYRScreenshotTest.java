package com.practisingDaily.screenshotTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HYRScreenshotTest {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");

        // take the screenshot of the w3Schools website
        HYRUtils.CaptureScreenshot(driver, "Image2.jpg");
        WebElement navigationElement = driver.findElement(By.id("navbtn_exercises"));
        navigationElement.click();

        //take the screenshot of Exercises Tab
        HYRUtils.CaptureScreenshot(driver, "Image3.jpg");

        /*TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshotTesting/FirstImage.png"));*/
        driver.quit();
    }
}
