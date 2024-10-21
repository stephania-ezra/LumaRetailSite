package org.luma.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    private final Logger log = LogManager.getLogger(CustomListener.class);
    private final BaseUtilTest btu = new BaseUtilTest();

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("my test failed at {} \n testMethod: {}"
                , result.getTestClass().getName(), result.getMethod().getMethodName());

        String fileName = result.getTestClass().getName()
                + "-"
                + result.getName()
                + ".jpg";
        ITestContext testContext = result.getTestContext();

        WebDriver driver = (WebDriver) testContext.getAttribute("WebDriver");
        log.info("context title is {}", driver.getTitle());

        btu.takeScreenShot(driver, fileName);
    }
}
