package selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;
import resources.ExtentReportNG;


public class Listeners extends BaseClass implements ITestListener{
	

	//If u use testNg version greater than 7.0 then manually add unimplemented methods
	//right click on listeners class->source->add unimplemented methods
	
	ExtentReports extent = ExtentReportNG.getExtent();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Telling to Threadlocal tht ExtentTest has to be thread safe
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();//Getting the failed method name
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1){
			// TODO Auto-generated catch block
			
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), testMethodName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}






}
