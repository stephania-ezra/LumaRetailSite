package com.practisingDaily.screenshotTest;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(Utils.class);

    public static void CaptureScreenshot(WebDriver driver, String Filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshotTesting/" + Filename));
        log.info("Screenshot saved successfully");
    }
}
