package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Getting the Browser Name and Browser Version
 * displaying the System details, Environment details
 * along with the author, device, tags
 */
public class Chapter9 {
    public static Logger log = LogManager.getLogger(Chapter9.class);

    public static void main(String[] args) throws IOException {
        ExtentReports er = new ExtentReports();

        File file = new File("reports.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);
        ExtentSparkReporterConfig config = esr.config();

        config.setTheme(Theme.DARK);
        config.setDocumentTitle("I am happy today");
        config.setCss("badge-primary{background-color:fecd2f}");
        config.setReportName("Learning Report ha ha");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");

        er.setSystemInfo("OS",System.getProperty("os.name"));
        er.setSystemInfo("Java Version",System.getProperty("java.version"));
        er.setSystemInfo("user",System.getProperty("user.name"));
        er.setSystemInfo("OS Version",System.getProperty("os.version"));

        WebDriver driver = new ChromeDriver();
        Capabilities c = ((RemoteWebDriver) driver).getCapabilities();
        //Browser name ,Browser Version

        //log.info("Browser Name is: {}", c.getBrowserName());
        //log.info("Browser Version is: {}", c.getBrowserVersion().substring(0,3));

        er.setSystemInfo("OS",c.getBrowserName() +c .getBrowserVersion().substring(0,3));

        er.attachReporter(esr);
        er.createTest("Test1","This test is for testing the look and feel")
                .info("This is an information message")
                .assignAuthor(new String[] {"Collins","Stephania"})
                .assignCategory(new String[]{"Smoke","Sanity","Regression"})
                .assignDevice(new String[]{"Chrome 99"})
                .pass("This test is passed");

        er.attachReporter(esr);
        er.createTest("Test2","This test is for testing the look and feel")
                .info("This is an information message")
                .assignAuthor("Collins","Stephania","Dave")
                .assignCategory("Smoke","Sanity","Regression")
                .assignDevice("Chrome 99","Edge 99")
                .fail("This test is failed");

        er.attachReporter(esr);
        er.createTest("Test3","This test is for testing the look and feel")
                .info("This is an information message")
                .assignAuthor("Ezra")
                .assignCategory("Sanity")
                .assignDevice("Edge 99")
                .skip("This test is skipped");

        er.attachReporter(esr);
        er.createTest("Test3","This test is for testing the look and feel")
                .info("This is an information message")
                .assignDevice("Firefox 99")
                .assignCategory("Regression")
                .assignAuthor("Rebecca")
                .warning("This test is Warning");

        er.flush();
        Desktop.getDesktop().browse(new File("reports.html").toURI());

//substring(0,c.getBrowserVersion().indexOf("."))) u can also give like this
        //System.getProperties().list(System.out); list all the properties

        //log.info(System.getProperty("os.name"));
        //log.info("OS Version {}", System.getProperty("os.version"));
        //log.info("User Name: {}", System.getProperty("user.name"));
        //log.info("Java {}", System.getProperty("java.version"));
        driver.quit();
    }
}
