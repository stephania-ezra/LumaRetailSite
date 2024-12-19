package learning.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SampleReportTest {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
    WebDriver driver;

    @BeforeTest
    public void browserLaunch() {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My First Extent Reports");
        extent.attachReporter(spark);

        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/?gws_rd=cr");

    }

    @AfterTest
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void testCase_001() throws IOException {
        ExtentTest test = extent.createTest("Verifying the page Title")
                .assignAuthor("Rahul")
                .assignCategory("Smoke")
                .assignDevice("Chrome");
        test.info("Capturing the page Title");

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "google", "Page Title is mismatched");
        test.pass("Page Title is Verified:" + pageTitle);
        Desktop.getDesktop().browse(new File("target/spark.html").toURI());
    }
}

