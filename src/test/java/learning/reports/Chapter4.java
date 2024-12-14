package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chapter4 {
    public static void main(String[] args) throws IOException {
        ExtentReports er = new ExtentReports();

        File file = new File("Extent Report Learning.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);

        //attach the report to the reporter
        er.attachReporter(esr);

      // ExtentTest et = er.createTest("First Test");
      // et.pass("First Test Passed");

        //using method chaining
        er.createTest("First Test")
                .log(Status.SKIP,"skip")
        .log(Status.PASS,"Pass")
        .log(Status.FAIL,"Fail")
        .log(Status.WARNING,"Warning")
        .log(Status.INFO,"info")
        .log(Status.PASS,"Pass")
        .log(Status.INFO,"INFO");

       er.flush();
        Desktop.getDesktop().browse(new File("Extent Report Learning.html").toURI());
    }
}
/**
 * order
 * FAIL
 * SKIP
 * WARNING
 * PASS
 * INFO
 */