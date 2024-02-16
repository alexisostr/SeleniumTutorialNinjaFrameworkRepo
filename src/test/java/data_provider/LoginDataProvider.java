package data_provider;

import org.testng.annotations.DataProvider;
import utilites.ReadExcelUtil;


public class LoginDataProvider {
	@DataProvider (name ="loginGetData")
	public Object[][] getLoginData() {

		Object data [][] =ReadExcelUtil.getTestData("login_test");;
		return data;
	}
	
	@DataProvider (name ="loginGetInvalidData")
	public Object[][] getInvalidLoginData() {

		Object data [][] =ReadExcelUtil.getTestData("negative_login_test");;
		return data;
	}
}
