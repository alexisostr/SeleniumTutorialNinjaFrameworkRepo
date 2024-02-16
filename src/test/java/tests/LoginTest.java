package tests;

import org.testng.annotations.Test;

import data_provider.LoginDataProvider;
import pages.HomePage;
import pages.LoginPage;
import utilites.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends Base {
	
	HomePage home;
	LoginPage login;
	
	@BeforeMethod
	public void setUp() {
		initializeDriverAndOpenApplication();
		home = new HomePage(driver);
		login =home.navigateToLoginPage();
	}

	
	@Test(priority =0,dataProvider = "loginGetData", dataProviderClass = LoginDataProvider.class)
	public void verifyLoginWithValidCredentials(String email, String password){
		login.loginToMyAccount(email, password);	
		Assert.assertEquals(driver.getTitle(), dataProp.getProperty("myAccountPageTitle"));
	}

	@Test(priority = 1,dataProvider = "loginGetInvalidData", dataProviderClass = LoginDataProvider.class )
	public void verifyLoginWithInvalidCredentials(String password) {
		login.loginToMyAccount(Utils.generateEmailWithTimeStamp(), password);
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("loginWarningMessage")));
		driver.close();

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidEmaiAndValidPassword() {
		login.loginToMyAccount(Utils.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("loginWarningMessage")));

	}

	@Test(priority = 3,dataProvider = "loginGetInvalidData", dataProviderClass = LoginDataProvider.class )
	public void verifyLoginWithValidEmaiAndInvalidPassword(String password) {
		login.loginToMyAccount(prop.getProperty("validEmail"), password);
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("loginWarningMessage")));

	}

	@Test(priority = 4)
	public void verifyLoginWithoutProvidingCredentials() {
		login.clickLoginButton();
		Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("loginWarningMessage")));

	}
}
