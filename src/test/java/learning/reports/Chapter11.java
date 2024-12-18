package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Extent Report only for Failed tests
 * Extent Report only for skipped and Warning tests
 */
public class Chapter11 {

    public static void main(String[] args) throws IOException {

        ExtentReports er = new ExtentReports();

        //File file = new File("Extent Report attributes.html");

        ExtentSparkReporter esr_all = new ExtentSparkReporter("AllTests.html");
        ExtentSparkReporter esr_failed = new ExtentSparkReporter("FailedTests.html");

        //filter only the failed test
        // while generating the report itself we are filtering the failed test :)
        esr_failed.filter().statusFilter().as(new Status[]{Status.FAIL}).apply();

        ExtentSparkReporter esr_skipAndWarning = new ExtentSparkReporter("SkipAndWarningTests.html");
// filter only the Skip and Warning tests
        esr_skipAndWarning.filter().statusFilter().as(new Status[]{
               Status.SKIP,
               Status.WARNING
        }).apply();

        er.attachReporter(esr_all,esr_failed,esr_skipAndWarning);

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

        er.createTest("Test3","First Test for Attribute")
                .assignAuthor("Ezra")
                .assignCategory("Sanity")
                .assignDevice("Edge 99")
                .skip("This test is failed");

        er.createTest("Test4","First Test for Attribute")
                .assignAuthor("Ezra")
                .assignCategory("Sanity")
                .assignDevice("Edge 99")
                .warning("This test is failed");

        // changing the order of the attributes
        er.createTest("Test5","changing the order")
                .assignDevice("Firefox 99")
                .assignCategory("Regression")
                .assignAuthor("Rebecca")
                .fail("This test is failed");

        // one of the attribute is not given in test
        er.createTest("Test6","Device Attribute not given")
                .assignCategory("Sanity")
                .assignAuthor("Reeta")
                .fail("This test is failed");

        //Multiple information in attributes
        er.createTest("Test7","Multiple Attribute for Tests")
                .assignAuthor("Collins","Stephania","Dave")
                .assignCategory("Smoke","Sanity","Regression")
                .assignDevice("Chrome 99","Edge 99")
                .pass("This test is passed");

        //multiple attributes in the form of arrays
        er.createTest("Test8","Multiple Attributes in arrays for Tests")
                .assignAuthor(new String[] {"Collins","Stephania"})
                .assignCategory(new String[]{"Smoke","Sanity","Regression"})
                .assignDevice(new String[]{"Chrome 99"})
                .pass("This test is passed");

        Throwable t = new RuntimeException("This is a Customized Exception");
        er.createTest("Arithmetic Exception Test")
                .fail(t);

        er.flush();
        Desktop.getDesktop().browse(new File("AllTests.html").toURI());
        Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
        Desktop.getDesktop().browse(new File("SkipAndWarningTests.html").toURI());
    }
}
