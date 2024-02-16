package data_provider;

import org.testng.annotations.DataProvider;

import utilites.ReadExcelUtil;

public class SearchDataProvider {
	
	@DataProvider (name ="searchGetData")
	public Object[][] getLoginData() {

		Object data [][] =ReadExcelUtil.getTestData("search_test");;
		return data;
	}
	
	@DataProvider (name ="searchGetInvalidData")
	public Object[][] getInvalidLoginData() {

		Object data [][] =ReadExcelUtil.getTestData("negative_search_test");;
		return data;
	}

}
