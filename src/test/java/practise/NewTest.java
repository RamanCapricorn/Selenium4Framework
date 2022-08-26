package practise;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class NewTest extends baseClass{

	int i=0;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Reports/"+ filename +".html");
	
	@BeforeClass
	public void Testbefore() throws IOException, InterruptedException, AWTException {

		if(i==0) {
			setupTest();
		}
		i=i+1;  
	}

	@AfterClass
	public void afterMethod(){

		if(i==0 || i==RowsCount()) {
			TestAfterMethod();
		}
	}
	
	@BeforeTest
	public void beforeTest() {

		extent.attachReporter(spark);
	}

	@Test
	public void f1() {
		
//		NewTest wait = new NewTest();
		test = extent.createTest("Launch browser and website").assignAuthor("Raman Kumar")
				.assignCategory("Smoke Test").assignDevice("Chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		testCaseName = driver.getTitle();
		
		WebElement loginBtn =  driver.findElement(By.id("btnLogin"));
		WebElement username = driver.findElement(By.id("txtUsername"));
//		wait.waits().until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("Admin");
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn)).sendKeys("admin123");
		CaptureScreen();
		loginBtn.click();
		
		test.log(Status.PASS, "User Launched website");
		test.pass("User launched website successfully");
	}

	@Test
	public void f2() {
		test = extent.createTest("Verify Login").assignAuthor("Suresh")
				.assignCategory("Sanity Test").assignDevice("Firefox");
		test.info("Alert displayed");
		test.pass("User logged into application");
		test.warning("Reset Password alert displayed");
	}

	@Test
	public void f3() {
		ExtentTest test = extent.createTest("Verify Dashboard").assignAuthor("Raman Kumar")
				.assignCategory("Regression Test").assignDevice("Chrome");
		test.skip("Dashboard skipped");
	}

	@Test
	public void f4() {
		ExtentTest test = extent.createTest("Verify user send emails from test application").assignAuthor("Anil")
				.assignCategory("Business Test").assignDevice("IE");
		test.fail("Unable to send email due to server down time");
	}

	@Test
	public void f5() {
		ExtentTest test = extent.createTest("Verify Reports and Analytics").assignAuthor("Raman Kumar")
				.assignCategory("Smoke Test").assignDevice("Safari");
		test.fail("Unable to verify reports");
	}

	@Test
	public void f6() {
		ExtentTest test = extent.createTest("Verify Logout").assignAuthor("Raman Kumar")
				.assignCategory("Smoke Test").assignDevice("Chrome");
		test.pass("User logout from the application");
		test.info("User is redirected to login page");
	}



	@AfterTest
	public void afterTest() {
		extent.flush();
	}

}
