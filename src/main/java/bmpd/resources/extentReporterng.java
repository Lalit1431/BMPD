package bmpd.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterng {
	ExtentReports extent;
	 public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		 reporter.config().setReportName("BMPD Automation Result");
		 reporter.config().setDocumentTitle("BMPD Test Reports");

		 ExtentReports extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Lalit Jadhav");
		 return extent;	
		 
		 
	 }
	
	
	
	
	
	
}
