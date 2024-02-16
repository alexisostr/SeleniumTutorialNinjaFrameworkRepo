package utilites;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;

import tests.Base;

public class Utils {
	
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_LOAD_TIME =10;
	

	//Generate Time Stamp for email address
	 public static String generateEmailWithTimeStamp() {
		  Date date = new Date();
		   String emailStamp = date.toString().replace(" ","_").replace(":","_");
		  return "alex" + emailStamp + "@test.com";
		  
	 }
	 
	 // Capture screenshot
	 
	 public static void CaptureScrehshot(String testName, ExtentTest extentTest) {
		 TakesScreenshot scrShot =((TakesScreenshot)Base.driver);
	     File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
	     String destinationScreenshot = System.getProperty("user.dir")+"\\Screenshots\\" + testName + ".png";
	     File DestFile=new File(destinationScreenshot);
	     try {
	    	 FileUtils.copyFile(SourceFile, DestFile);
	    	// Add screenshot to extent report
				extentTest.addScreenCaptureFromPath(destinationScreenshot);
	     }
	     catch(IOException e){   	 
	    	e.printStackTrace();    	 
	     }
	 }
}
