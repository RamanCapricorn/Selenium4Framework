package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiBrowserTest {

	WebDriver driver =null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			System.out.println("Browser Name: "+ browserName);
			System.out.println("Thread Id: "+ Thread.currentThread().getId());
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("start-maximized");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			System.out.println("Browser Name: "+ browserName);
			System.out.println("Thread Id: "+ Thread.currentThread().getId());

		}
		
		else if(browserName.equalsIgnoreCase("IE")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(options);
			System.out.println("Browser Name: "+ browserName);
			System.out.println("Thread Id: "+ Thread.currentThread().getId());
		}
	}
	
	@Test
	public void multiTest() throws InterruptedException {
		
		driver.get("https://google.com");
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}
