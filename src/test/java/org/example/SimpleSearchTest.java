package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SimpleSearchTest extends LumaLoginTest {

    @AfterTest
    void tearDown() {
        BaseTestUtils.tearDown(driver);
    }

    @Test(groups = {"smoke"})
    public void search() {
        login();
        System.out.println(driver.getCurrentUrl());

        WebElement searchTextBox = driver.findElement(By.id("search"));
        searchTextBox.sendKeys("yoga pants");

//        search_mini_form
        WebElement searchForm = driver.findElement(By.id("search_mini_form"));
        searchForm.submit();
    }
}