package utilites;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports generateExtentReport() {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		File extendReportFile = new File(".\\reports\\" +  repName );
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extendReportFile); 
		
		//SparkReport configuration
		sparkReporter.config().setDocumentTitle("Selenium Ninjia Project"); // Title of report
		sparkReporter.config().setReportName("Selenium Ninjia Tests Result  Report"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh::mm::ss");
		
		//Extent Report configuration
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Selenium Ninja Hybrid Project");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("JAVA version", System.getProperty("java.version"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Alex Ostrovskiy");
		
		return extent;
	}

}
