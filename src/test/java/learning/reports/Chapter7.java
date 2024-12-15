package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chapter7 {

    public static void main(String[] args) throws IOException {

        ExtentReports er = new ExtentReports();

        File file = new File("Extent Report attributes.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);

        er.attachReporter(esr);

        er.createTest("Test1","First Test for Attribute")
                .assignAuthor("Collins")
                .assignCategory("Smoke")
                .assignDevice("Chrome 99")
                .pass("This test is passed");

        er.createTest("Test2","First Test for Attribute")
                .assignAuthor("Ezra")
                .assignCategory("Sanity")
                .assignDevice("Edge 99")
                .fail("This test is failed");

        // changing the order of the attributes
        er.createTest("Test3","changing the order")
                .assignDevice("Firefox 99")
                .assignCategory("Regression")
                .assignAuthor("Rebecca")
                .fail("This test is failed");

        // one of the attribute is not given in test
        er.createTest("Test4","Device Attribute not given")
                .assignCategory("Sanity")
                .assignAuthor("Reeta")
                .fail("This test is failed");

        //Multiple information in attributes
        er.createTest("Test5","Multiple Attribute for Tests")
                .assignAuthor("Collins","Stephania","Dave")
                .assignCategory("Smoke","Sanity","Regression")
                .assignDevice("Chrome 99","Edge 99")
                .pass("This test is passed");

        //multiple attributes in the form of arrays
        er.createTest("Test6","Multiple Attributes in arrays for Tests")
                .assignAuthor(new String[] {"Collins","Stephania"})
                .assignCategory(new String[]{"Smoke","Sanity","Regression"})
                .assignDevice(new String[]{"Chrome 99"})
                .pass("This test is passed");

        er.flush();
        Desktop.getDesktop().browse(new File("Extent Report attributes.html").toURI());
    }
}
