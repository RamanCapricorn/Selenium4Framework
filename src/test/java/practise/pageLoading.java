package practise;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageLoading {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);// Webdriver wait until load event fire is returned.
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Webdriver wait until DOMContentLoaded event fire is returned.
//		options.setPageLoadStrategy(PageLoadStrategy.NONE);	 // 
		WebDriverManager.chromedriver().setup();

		WebDriver driver =  new ChromeDriver(options);
		driver.get("https://google.com");
		
		driver.quit();

	}

}

//https://stackoverflow.com/questions/9899372/vanilla-javascript-equivalent-of-jquerys-ready-how-to-call-a-function-whe