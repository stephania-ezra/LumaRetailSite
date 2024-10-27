package com.tutorials.hyr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependencyTest extends BaseUtilTest {
    public static WebDriver driver = new ChromeDriver();
    static String TrackingNumber = null;
    private final Logger log = LogManager.getLogger(DependencyTest.class);
    private final BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }


  /*  @Test
    public void CreateShipment() {
        log.info(5 / 0);
        log.info("CREATING SHIPMENT");
        TrackingNumber = "134DF0JKL";
    }*/

    @Test(dependsOnMethods = {"CreateShipment"},
            ignoreMissingDependencies = true)
    public void TrackShipment() throws Exception {
        if (TrackingNumber != null)
            log.info("TRACKING SHIPMENT");
        else {
            throw new Exception("INVALID TRACKING NUMBER");
        }
    }

    @Test(dependsOnMethods = {"CreateShipment", "TrackShipment"}, ignoreMissingDependencies = true)
    public void CancelShipment() throws Exception {
        if (TrackingNumber != null)
            log.info("CANCEL SHIPMENT");
        else
            throw new Exception("INVALID TRACKING NUMBER");
    }
}


