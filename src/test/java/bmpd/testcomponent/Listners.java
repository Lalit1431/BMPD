package bmpd.testcomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import bmpd.resources.extentReporterng;

public class Listners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent=extentReporterng.getReportObject();
	ThreadLocal<ExtentTest> extetnTest=new ThreadLocal<ExtentTest>();
			
	@Override
	public void onTestStart(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName());
		extetnTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	 extetnTest.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extetnTest.get().fail(result.getThrowable());
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	String path=null;
	try {
		getScreenshot(result.getMethod().getMethodName(), driver);
	} catch (IOException e) {
		e.printStackTrace();
	}
	extetnTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
	}
}
