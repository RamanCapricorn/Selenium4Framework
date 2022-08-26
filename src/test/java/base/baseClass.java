package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.SkipException;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;

import config.PropertiesFile;

import com.aventstack.extentreports.ExtentTest;

public class baseClass {

	public static int testStartRowNum;
	public static int dataRowNum;
	public static int colSRowNum;
	public static String testCaseName;
	public static ExtentTest test;
	public static int rows;
	public WebDriver driver;
	public Date d=new Date();
	public String filename = d.toString().replace(":","_").replace(" ","_");
	static Properties prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");
	public static String browserName=null;

	public static Xlsx_Reader xls = new Xlsx_Reader(System.getProperty("user.dir") + "\\Testdata\\TestCaseData.xlsx");

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(ProjectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			browserName = browser;
			System.out.println(browser);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(ProjectPath + "/src/test/java/config/config.properties");
			prop.setProperty("Result", "PASS");
			prop.store(output, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public void setupTest() {

		getProperties();
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//			options.addArguments("--headless");
			//	ChromeDriver driver = new ChromeDriver(options);
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(options);

			this.driver = driver;
			PageFactory.initElements( driver, this);
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("start-maximized");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver(options);

			this.driver = driver;
			PageFactory.initElements( driver, this);
		}
		
		else if(browserName.equalsIgnoreCase("IE")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			WebDriver driver = new InternetExplorerDriver(options);

			this.driver = driver;
			PageFactory.initElements( driver, this);
		}
	}

	public Wait<WebDriver> fwait(int withTimeoutMs, int pollingEverySec) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(withTimeoutMs))
				.pollingEvery(Duration.ofMillis(pollingEverySec))
				.ignoring(NoSuchElementException.class);
		return wait;
	}

	public void CaptureScreen()
	{
		Date d=new Date();
		String filename = testCaseName + "_" + d.toString().replace(":","_").replace(" ","_")+".jpg";


		String HtmlPath = "../Reports/ScreenShots/"+filename;
		String ImagePath = "./Reports/ScreenShots/"+filename;


		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagePath);
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {System.out.println(e.getMessage());}

		//		test.log(Status.PASS, "ScreenShot->"+ test.addScreenCapture(HtmlPath));
		test.log(Status.PASS, "ScreenShot->"+ test.addScreenCaptureFromPath(HtmlPath));
	}

	public void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void turnOffImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

	public static void isTestRunnable(Hashtable<String,String> data){
		if(!ExcelUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equals("N")){
			//xls.setCellData("TestData","Result",dataRowNum,testStartRowNum, "SKIP");
			test.log(Status.SKIP,"Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}	
	}

	/************************Set Result to Excel************************/

	public static void Result_to_Xls(Xlsx_Reader xls,String SheetName,int RowNum,String Result,String Result_columnname){

		xls.setCellData(SheetName,Result_columnname,RowNum, Result,colSRowNum);
	}


	/******************Reporting*****************************/

	public static void reportPass(String Msg){
		test.log(Status.PASS, Msg);
	}

	public static void reportFail(String Msg){
		test.log(Status.FAIL, Msg);
	}

	public static void reportSkip(String Msg){
		test.log(Status.SKIP, Msg);
	}

	public static int RowsCount() {
		return rows;
	}

	public void TestAfterMethod() {
		driver.close();
		//driver.quit();
		setProperties();
	}
}
