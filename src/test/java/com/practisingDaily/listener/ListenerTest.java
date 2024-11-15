package com.practisingDaily.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    public final Logger log = LogManager.getLogger(ListenerTest.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("'onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("onTestSkipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info("onTestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("onFinish");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("onTestStart");
    }
}
