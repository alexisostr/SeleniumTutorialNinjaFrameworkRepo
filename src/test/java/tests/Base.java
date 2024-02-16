package tests;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import utilites.Utils;

public class Base {
	public static  WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
public void loadPropertiesFile() {
	prop = new Properties();
	dataProp = new Properties();
	File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
	File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.properties");
	try {
		FileInputStream fis1 = new FileInputStream(propFile);
		FileInputStream fis2 = new FileInputStream(dataPropFile);
		
		prop.load(fis1);
		dataProp.load(fis2);
	}
	
	catch(Exception ex) {
		ex.printStackTrace();
	}
}
	
 public void initializeDriverAndOpenApplication() {
	  loadPropertiesFile();
	  System.setProperty("webdriver.chrome.driver",prop.getProperty("driverPath"));
	  //WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIME));
	  driver.get(prop.getProperty("url"));
  }
 
 @AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
