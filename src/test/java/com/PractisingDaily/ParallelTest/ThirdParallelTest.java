package com.PractisingDaily.ParallelTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ThirdParallelTest {
    public final Logger log = LogManager.getLogger(ThirdParallelTest.class);

    @Test
    public void eighthMethodTest() {
        log.info("TestClass3 >> testMethod8:{}", Thread.currentThread().threadId());
    }

    @Test
    public void ninthMethodTest() {
        log.info("TestClass3 >> testMethod9:{}", Thread.currentThread().threadId());
    }

    @Test
    public void tenthMethodTest() {
        log.info("TestClass3 >> testMethod10:{}", Thread.currentThread().threadId());
    }
}
