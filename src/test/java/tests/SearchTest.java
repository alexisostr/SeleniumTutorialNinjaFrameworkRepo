package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data_provider.SearchDataProvider;
import pages.HomePage;

public class SearchTest  extends Base {
	
	HomePage home;
	
  @BeforeMethod
  public void setUp() {
	  initializeDriverAndOpenApplication();
	  home = new HomePage(driver);
  }
  
 
  @Test(priority = 0, dataProvider = "searchGetData", dataProviderClass = SearchDataProvider.class)
  public void verifySearchWithValidProduct(String product) {	  
	  home.searchProduct(product);
	  Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("productResult")));
  }
  
  @Test(priority = 1, dataProvider = "searchGetInvalidData", dataProviderClass = SearchDataProvider.class)
  public void verifySearchWithInValidProduct(String product) {	  
	  home.searchProduct(product);
	  Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("noProductWarning")));
  }
  
  @Test(priority = 2)
  public void verifySearchWithoutAnyProduct() {
	  home.clickSearchButton();
	  Assert.assertTrue(driver.getPageSource().contains(dataProp.getProperty("noProductWarning")));
  }
}
