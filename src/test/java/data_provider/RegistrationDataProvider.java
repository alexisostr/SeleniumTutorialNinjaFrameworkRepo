package data_provider;

import org.testng.annotations.DataProvider;

import utilites.ReadExcelUtil;

public class RegistrationDataProvider {
	
	@DataProvider (name ="registerGetData")
	public Object[][] getRegisterData() {

		Object data [][] =ReadExcelUtil.getTestData("register_test");;
		return data;
	}

}
