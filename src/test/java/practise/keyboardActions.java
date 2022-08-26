package practise;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboardActions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		/*
		 * // Send Keys 
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("Cypress Tutorials", Keys.ENTER);
		 */
		
		/*
		 * // KeyDown() 
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("Cypress Tutorials", Keys.ENTER);
		 * Actions action = new Actions(driver); 
		 * Action keydown = action.keyDown(Keys.CONTROL).sendKeys("a").build(); 
		 * keydown.perform();
		 */
		// KeyUp() 
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium")
		.keyUp(Keys.SHIFT).sendKeys(" selenium").perform();
		
		Thread.sleep(2000);
		searchBox.clear();
		Thread.sleep(2000);
		driver.close();
	}

}
