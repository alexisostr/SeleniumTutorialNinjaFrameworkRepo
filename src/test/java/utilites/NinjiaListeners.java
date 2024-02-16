package utilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.Base;



public class NinjiaListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	public void onStart(ITestContext testContext) {
		extentReport = ExtentReport.generateExtentReport();
	}
	
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest =extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+ " started executing");
		
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		//extentTest.createNode(result.getName());
		//extentTest.assignCategory(result.getMethod().getGroups());		
		extentTest.log(Status.INFO, testName+ " passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		
		//**** Catch Screenshot and add to  extent report
		 Utils.CaptureScrehshot(testName,extentTest);
		//extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.INFO,testName+ "Test Failed");
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());
	}

		
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		//extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.INFO,testName+ "Test Skipped");
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());
	}
		

	public void onFinish(ITestContext testContext) {
		extentReport.flush();
	}

}
