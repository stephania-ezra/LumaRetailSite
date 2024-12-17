package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *configuring json , xml file
 * check with darli for the error message
 * Cannot invoke "com.aventstack.extentreports.config.ConfigStore.getStore()" because "store" is null
 *
 */

public class Chapter8 {
    public static void main(String[] args) throws IOException {
        ExtentReports er = new ExtentReports();

        File file = new File("reports.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);
        ExtentSparkReporterConfig config = esr.config();

        //modifications
        /*config.setTheme(Theme.DARK);
        config.setDocumentTitle("I am happy today");
        config.setCss("badge-primary{background-color:fecd2f}");
        config.setReportName("Learning Report ha ha");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");

        //changing the background color of the time details
        config.setCss(".badge-primary{background-color:#fd3259}");*/

        //disappearing the logo
        //config.setJs("document.getElementsByClassName('logo')[0].style.display='none'");

        // attaching the json to SparkReporter
        //esr.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));

        // attaching the xml to SparkReporter
      esr.loadXMLConfig(new File( "./src/test/resources/extent-reports-config.xml"));

        er.attachReporter(esr);

        er.createTest("Test1","This test is for testing the look and feel")
                .info("u can change the theme report name document title")
                .pass("This test is passed");
        er.flush();
        Desktop.getDesktop().browse(new File("reports.html").toURI());
    }
}
