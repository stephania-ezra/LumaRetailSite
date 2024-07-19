package org.luma;

import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})
public class SimpleSearchTest extends LumaLoginTest {

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        BaseTestUtils btu = new BaseTestUtils();
        btu.tearDown(driver);
    }

    @Test(groups = {"smoke"})
    public void search() {
        System.out.println("running search from " + Thread.currentThread().threadId());
        login();

        WebElement searchTextBox = driver.findElement(By.id("search"));
        searchTextBox.sendKeys("yoga pants");

        // search_mini_form
        WebElement searchForm = driver.findElement(By.id("search_mini_form"));
        searchForm.submit();
        System.out.println("search page: " + driver.getCurrentUrl());
    }
}