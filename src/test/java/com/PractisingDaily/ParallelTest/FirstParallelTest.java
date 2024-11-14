package com.PractisingDaily.ParallelTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class FirstParallelTest {

    public final Logger log = LogManager.getLogger(FirstParallelTest.class);

    @Test
    public void firstMethodTest() {
        log.info("TestClass1 >> testMethod1:{}", Thread.currentThread().threadId());
    }

    @Test
    public void secondMethodTest() {
        log.info("TestClass1 >> testMethod2:{}", Thread.currentThread().threadId());
    }

    @Test
    public void thirdMethodTest() {
        log.info("TestClass1 >> testMethod3:{}", Thread.currentThread().threadId());
    }

    @Test
    public void fourthMethodTest() {
        log.info("TestClass1 >> testMethod4:{}", Thread.currentThread().threadId());
    }
}
