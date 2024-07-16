package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SimpleSearchTest extends LumaLoginTest {

    @AfterClass
    void tearDown() {
        BaseTestUtils.tearDown(driver);
    }

    @Test(groups = {"smoke"})
    public void search() {
        login();

        WebElement searchTextBox = driver.findElement(By.id("search"));
        searchTextBox.sendKeys("yoga pants");

        // search_mini_form
        WebElement searchForm = driver.findElement(By.id("search_mini_form"));
        searchForm.submit();
        System.out.println("search page: " + driver.getCurrentUrl());
    }
}