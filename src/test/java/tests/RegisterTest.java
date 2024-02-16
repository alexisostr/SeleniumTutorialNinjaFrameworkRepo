package tests;

import org.testng.annotations.Test;

import data_provider.RegistrationDataProvider;
import pages.HomePage;
import pages.RegisterPage;
import utilites.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class RegisterTest extends Base {

 HomePage home ;
 RegisterPage register;
	
  
 
   @BeforeMethod
	public void setUp() {
	   
		initializeDriverAndOpenApplication();
		home = new HomePage(driver);
		register =home.navigateToRegisterPage();
	}

	

	@Test(priority = 0, dataProvider = "registerGetData", dataProviderClass = RegistrationDataProvider.class)
	public void verifyRegisterWithMandatoryFields(String fName, String lName, String phone, String password) {
		register.registerWithMandatoryFields(fName, lName, Utils.generateEmailWithTimeStamp(), phone, password);
		Assert.assertEquals(driver.getTitle(), dataProp.getProperty("newAccountPageTitle"));

	}

	@Test(priority = 1, dataProvider = "registerGetData", dataProviderClass = RegistrationDataProvider.class)
	public void verifyRegisterWithAllFields(String fName, String lName, String phone, String password) {
		register.registerWithAllFields(fName, lName, Utils.generateEmailWithTimeStamp(), phone, password);
		Assert.assertEquals(driver.getTitle(), dataProp.getProperty("newAccountPageTitle"));

	}

	@Test(priority = 2,  dataProvider = "registerGetData", dataProviderClass = RegistrationDataProvider.class)
	public void verifyRegisterWithExistingEmail(String fName, String lName, String phone, String password) {
		register.registerWithMandatoryFields(fName, lName, prop.getProperty("validEmail"), phone, password);
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("duplicationEmailWarning")));

	}

	@Test(priority = 3)
	public void verifyRegisterWithoutFillAnyDetails() {
		register.submitProfile();
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("firstNameWarning")));
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("lastNameWarning")));
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("privacyPolicyWarning")));
		 
	}
}
