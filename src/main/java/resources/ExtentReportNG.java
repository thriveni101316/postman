package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	public static ExtentReports getExtent()
	{
		String path = System.getProperty("user.dir")+"\\resources\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("WebTestResults");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Thriveni");
		return extent;
		
	}

}
