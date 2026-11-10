package listener_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.baseclass;
import generic_utility.java_utility;

public class list_imp implements ISuiteListener,ITestListener {
	public static ExtentReports report;
	@Override
	public void onStart(ISuite suite) {
		
	 
		String time=java_utility.getcurrentdatetime();
		ExtentSparkReporter spark=new ExtentSparkReporter("./adv_reports/"+time+".html");
		spark.config().setDocumentTitle("ANVNAcare report");
		spark.config().setReportName("login test report");
		spark.config().setTheme(Theme.DARK);
		
		 report = new ExtentReports();
			report.attachReporter(spark);

			report.setSystemInfo("Browser", "Configured Browser");
			report.setSystemInfo("Operating System", "Windows 11");
			report.setSystemInfo("Tester", "QA Automation");

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test=report.createTest(result.getName());
		test.log(Status.PASS,result.getName()+"passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test=report.createTest(result.getName());
		test.log(Status.FAIL,result.getName()+"failed");
		TakesScreenshot tks=(TakesScreenshot) baseclass.sdriver;
		String ss=tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest test=report.createTest(result.getName());
		test.log(Status.SKIP,result.getName()+"skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	

}
