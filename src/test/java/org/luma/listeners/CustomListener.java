package org.luma.listeners;

import org.luma.BaseTestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    private final BaseTestUtils btu = new BaseTestUtils();

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("my test failed at " + result.getTestClass().getName()
                + " \n testMethod: " + result.getMethod().getMethodName());

        String fileName = result.getTestClass().getName()
                + "-"
                + result.getName()
                + ".jpg";
        ITestContext testContext = result.getTestContext();

        WebDriver driver = (WebDriver) testContext.getAttribute("WebDriver");
        System.out.println("context title is " + driver.getTitle());

        btu.takeScreenShot(driver, fileName);
    }
}
