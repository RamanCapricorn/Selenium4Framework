package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {

	@Test
	public void Test1() throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//		options.addArguments("--headless");
		//	ChromeDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://tinypng.com/");
		driver.findElement(By.xpath("//section[@class='upload']//figure[@class='icon']")).click();
		
		Runtime.getRuntime().exec("G:\\Frameworks\\FileUploadScript.exe");
		Thread.sleep(7000);
		driver.close();
	}
}
