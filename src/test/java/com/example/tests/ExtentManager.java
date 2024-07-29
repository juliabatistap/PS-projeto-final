package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {

    private static ExtentReports extent;
    private static Map<Integer, ExtentTest> extentTests = new HashMap<>();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("target/extent-reports/extent-report.html");
        }
        return extent;
    }

    public static synchronized ExtentTest getOrCreateTest(int threadId) {
        ExtentTest test = extentTests.get(threadId);
        if (test == null) {
            test = extent.createTest("Test Name", "Test Description");
            extentTests.put(threadId, test);
        }
        return test;
    }
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        return extent;
    }
}
