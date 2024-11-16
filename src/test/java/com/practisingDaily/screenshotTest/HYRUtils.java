package com.practisingDaily.screenshotTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HYRUtils {

    public static void CaptureScreenshot(WebDriver driver, String Filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshotTesting/" + Filename));
    }
}
