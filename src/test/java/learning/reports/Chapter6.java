package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Extent reports for test level and Log Level
 */
public class Chapter6 {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        ExtentReports er = new ExtentReports();

        File file = new File("Extent Report part3.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);

        er.attachReporter(esr);
        driver.get("https://www.google.co.in/?gws_rd=cr");

Chapter6 c6 = new Chapter6();
        String base64Code = c6.captureScreenshot();
        String path = c6.captureScreenShot("Google.jpg");
        //adding description to the tests
        er.createTest("Screenshot of Test1", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(base64Code);

//adding title
        er.createTest("Screenshot of Test2", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page");

        //adding multiple images
        er.createTest("Screenshot of Test3", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page1")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page2")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page3")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page4")
                .addScreenCaptureFromBase64String(base64Code, "Google Home Page5");

//addScreenCaptureFromPath() method
        er.createTest("Screenshot of Test4", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromPath(path);

        //addScreenCaptureFromPath() method , overloading
        er.createTest("Screenshot of Test5", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromPath(path, "Test 4 title message");

        //adding multiple images

        er.createTest("Screenshot of Test6", "This is my first test" +
                        " for creating screenshot at Test Level")
                .info("This is an info message")
                .addScreenCaptureFromPath(path, "Test 4 title message1")
                .addScreenCaptureFromPath(path, "Test 4 title message2")
                .addScreenCaptureFromPath(path, "Test 4 title message3")
                .addScreenCaptureFromPath(path, "Test 4 title message4")
                .addScreenCaptureFromPath(path, "Test 4 title message5");

        // Extent reports for Log level -Fail and output type - BASE64
        er.createTest("Screenshot of Test7", "This is my first test" +
                " for creating screenshot at Log Level")
                        .info("This is an Information Message")
                                .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());

        // Extent reports for Log level -Fail and output type - BASE64 with title

        er.createTest("Screenshot of Test8", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Title page").build());

//Extent Reports for Log Level - Fail with output type - FILE
        er.createTest("Screenshot of Test9", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail (MediaEntityBuilder.createScreenCaptureFromPath(path).build());

        //Extent Reports for Log Level - Fail with output type - FILE with title
        er.createTest("Screenshot of Test10", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail (MediaEntityBuilder.createScreenCaptureFromPath(path," Google Home Page ").build());

        //Extent Reports for Log Level - Fail with output type - base64 with title
        //method fail(String , media)
        er.createTest("Screenshot of Test11", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail("Any String Message",MediaEntityBuilder.createScreenCaptureFromBase64String
                        (base64Code,"Title page").build());

        //Extent Reports for Log Level - Fail with output type - FILE with title
        //method fail(String , media)
        er.createTest("Screenshot of Test12", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail ("This is a sample message",MediaEntityBuilder.createScreenCaptureFromPath
                        (path," Google Home Page ").build());

        //Extent Reports for Log Level - Fail with output type - base64 with title
        //method fail(throwable , media)

        Throwable t = new Throwable("This is my Throwable Exception");
        er.createTest("Screenshot of Test13", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String
                        (base64Code,"Title page").build());

        //Extent Reports for Log Level - Fail with output type - FILE with title
        //method fail(throwable , media)

        er.createTest("Screenshot of Test14", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .fail (t,MediaEntityBuilder.createScreenCaptureFromPath
                        (path," Google Home Page ").build());


        //trying SKIP log test
        /*Throwable t = new Throwable("Testing chumma");
        er.createTest("Screenshot of Test15", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .skip (t,MediaEntityBuilder.createScreenCaptureFromPath
                        (path," Google Home Page ").build());*/

        //trying WARNING log test
       /* Throwable t = new Throwable("Testing Warning log chumma");
        er.createTest("Screenshot of Test16", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .warning(t,MediaEntityBuilder.createScreenCaptureFromPath
                        (path," Google Home Page ").build());*/

        //trying PASS log test
        /*Throwable t = new Throwable("Testing Pass log chumma");
        er.createTest("Screenshot of Test17", "This is my first test" +
                        " for creating screenshot at Log Level")
                .info("This is an Information Message")
                .pass(t,MediaEntityBuilder.createScreenCaptureFromPath
                        (path," Google Home Page ").build());*/


        er.flush();
        driver.quit();
        Desktop.getDesktop().browse(new File("Extent Report part3.html").toURI());
    }

    //Output Type - BASE64
    public String captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64Code = ts.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot saved successfully");
        return base64Code;
    }

    //Output type =file
    public String captureScreenShot(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
        return destFile.getAbsolutePath();
    }
}