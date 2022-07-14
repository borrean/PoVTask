package com.pov.automation.essentials.testUtilities.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/extent-report.html");
        reporter.config().setReportName("Test report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Dino Letic");
        return extentReports;
    }
}
