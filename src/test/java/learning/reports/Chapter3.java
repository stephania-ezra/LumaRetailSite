package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Chapter3 {
    public static void main(String[] args) throws IOException {
        ExtentReports er = new ExtentReports();
       // ExtentSparkReporter esr = new ExtentSparkReporter("first report.html"); // passing string instance to ExtentSparkReporter

        File file = new File("first report.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file); // passing file instance to ExtentSparkReporter

        er.attachReporter(esr);

       //et.createTest("Test 1");
        ExtentTest test1 = er.createTest("Test 1");
        test1.pass("Test is passed"); // using pass method

        ExtentTest test2 = er.createTest("Test 1");
        test2.log(Status.FAIL,"Test2 is Failed"); // using log method
        
        er.createTest("Test 3").skip("Test3 is skipped");

                //ExtentSparkReporter esr2 = new ExtentSparkReporter(String.valueOf(Paths.get("src", "test"
                //, "resources", "first report.html")));

        er.flush();//after u give flush() then only report will b available in the path

        Desktop.getDesktop().browse(new File("first report.html").toURI());
    }
}
