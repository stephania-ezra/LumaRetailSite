package com.practisingDaily.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ListenerTest.class})
public class ListenerClassTest {

    public final Logger log = LogManager.getLogger(ListenerClassTest.class);

    @Test
    //pass method
    public void testMethod1() {
        log.info("I'm inside TestMethod1");
    }

    @Test
    //Method failed by assertion
    public void testMethod2() {
        log.info("I'm inside TestMethod2");
        Assert.fail();
    }

    @Test(timeOut = 1000)
    //timeout error
    public void testMethod3() throws InterruptedException {
        Thread.sleep(2000);
        log.info("I'm inside TestMethod3");
    }

    // method will be skipped , since depending on fail method testMethod3
    @Test(dependsOnMethods = "testMethod3")
    public void testMethod4() {
        log.info("I'm inside TestMethod4");
    }
}
