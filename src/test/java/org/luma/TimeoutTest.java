package org.luma;

import org.luma.listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})
public class TimeoutTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @Test(timeOut = 2000, testName = "timeOutChecking")
    public void timeoutCheck() {
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/");
        System.out.println(driver.getTitle());
        driver.quit();
        System.out.println("HYR Tutorials Webpage is Displayed Successfully");
    }
}
