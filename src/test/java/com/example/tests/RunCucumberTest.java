package com.example.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.tests",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class RunCucumberTest {

    private static ExtentReports extent;

    @BeforeClass
    public static void setup() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/extent-report.html");
        sparkReporter.config().setReportName("My Project Report");
        sparkReporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @AfterClass
    public static void teardown() {
        extent.flush();
    }
}
