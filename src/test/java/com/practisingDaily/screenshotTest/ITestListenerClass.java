package com.practisingDaily.screenshotTest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //screenshots need to be saved in test method name
        //captureScreenShots(result.getMethod().getMethodName() + ".jpg");
        //along with the method name , i also want the test name in xml file to be displayed
        captureScreenShots(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
    }
}
