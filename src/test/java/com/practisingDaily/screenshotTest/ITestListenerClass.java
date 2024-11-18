package com.practisingDaily.screenshotTest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //screenshots need to be saved in test method name
        captureScreenShots(result.getMethod().getMethodName() + ".jpg");
    }
}
