package practise;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.baseClass;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class firstTest extends baseClass{

	@BeforeClass
	public void beforeClass() {
		setupTest();
	}
	
	@Test
	public void main(String[] args) throws InterruptedException {

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("start-maximized");
//		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
////		ChromeDriver driver = new ChromeDriver(options);
//		WebDriverManager.chromedriver().setup();
//
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Wait<WebDriver> wait = fwait(500, 10);


		driver.get("https://google.com");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

		WebElement loginBtn =  driver.findElement(By.id("btnLogin"));

		WebElement username = driver.findElement(By.id("txtUsername"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("Admin");
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn)).sendKeys("admin123");
		loginBtn.click();
		Thread.sleep(2000);
		driver.close();
	}

}
