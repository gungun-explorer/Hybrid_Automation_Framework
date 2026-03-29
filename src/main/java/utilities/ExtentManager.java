package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReportInstance() {

        ExtentSparkReporter reporter =
            new ExtentSparkReporter("reports/report.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}