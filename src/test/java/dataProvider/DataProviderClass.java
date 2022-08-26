package dataProvider;

import org.testng.annotations.DataProvider;

import base.baseClass;
import base.ExcelUtil;

public class DataProviderClass extends baseClass{

	@DataProvider(name = "google Regression Test")
	public Object[][] googlePositive(){
		
		return ExcelUtil.getTestData(xls, "google Regression Test");
	}
	
}
