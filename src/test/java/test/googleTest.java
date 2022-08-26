package test;

import java.util.Hashtable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.baseClass;
import dataProvider.DataProviderClass;
import pages.googleHome;

public class googleTest extends baseClass {

	int i=0;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Reports/"+ filename +".html");
	
	@BeforeClass
	public void beforeClass() {
		if(i==0) {
			setupTest();
		}
		i=i+1;
	}
	
	@BeforeTest
	public void beforeTest() {

		extent.attachReporter(spark);
	}

	@Test(dataProvider = "google Regression Test", dataProviderClass = DataProviderClass.class, priority = 1)
	public void googleSearch(Hashtable<String, String> data) {
		try {
			
			ImplicitWait();
			testCaseName="google Regression Test";
			test = extent.createTest("Launch browser and website").assignAuthor("Raman Kumar")
					.assignCategory("Regression Test").assignDevice("Chrome");
			
			isTestRunnable(data);
			googleHome ghome = new googleHome(driver);

			driver.get("https://google.com");
			CaptureScreen();
			ghome.inputSearch(data.get("Search"));
			
			test.log(Status.PASS, "User Launched website");
			test.pass("User launched website successfully");
			
			int rowNum=Integer.parseInt(data.get("row"));
			Result_to_Xls(xls,"TestData",rowNum,"PASS","Result");
		}
		
		catch(Exception e){

			System.out.println("Error Message:"+ e.getMessage());

			if(e.getMessage().equals("Skipping the test as runmode is N"))
			{
				reportSkip(e.getMessage());
				int rowNum=Integer.parseInt(data.get("row"));
				Result_to_Xls(xls,"TestData",rowNum,"Skip","Result");	
			}
			else							
			{
				reportFail(e.getMessage());
				CaptureScreen();
				int rowNum=Integer.parseInt(data.get("row"));
				Result_to_Xls(xls,"TestData",rowNum,"Fail","Result");
			}
		}
	}
	
	@AfterTest
	public void afterTest() {
		extent.flush();
	}

	@AfterClass
	public void afterMethod(){

		if(i==0 || i==RowsCount()) {
			TestAfterMethod();
		}
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}

}
