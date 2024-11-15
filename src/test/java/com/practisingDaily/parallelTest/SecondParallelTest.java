package com.practisingDaily.parallelTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SecondParallelTest {

    public final Logger log = LogManager.getLogger(SecondParallelTest.class);

    @Test
    public void fifthMethodTest() {
        log.info("TestClass2 >> testMethod5:{}", Thread.currentThread().threadId());
    }

    @Test
    public void sixthMethodTest() {
        log.info("TestClass2 >> testMethod6:{}", Thread.currentThread().threadId());
    }

    @Test
    public void seventhMethodTest() {
        log.info("TestClass2 >> testMethod7:{}", Thread.currentThread().threadId());
    }
}
