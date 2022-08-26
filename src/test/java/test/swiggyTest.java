package test;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class swiggyTest {
	
	@Test
	public void findLocation() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
//		ChromeDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		SwiggyHome sHome = new SwiggyHome(driver);
		
		driver.get("https://www.swiggy.com/");
		
		sHome.inputLocation("Pune");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
										.withTimeout(Duration.ofMillis(5000))
										.pollingEvery(Duration.ofSeconds(5))
										.ignoring(NoSuchElementException.class);
		
//		wait.until(ExpectedConditions.elementToBeClickable(sHome.txtLocation));
		
		sHome.clickLocation();
		sHome.clickRestaurant();
		
	}
}
