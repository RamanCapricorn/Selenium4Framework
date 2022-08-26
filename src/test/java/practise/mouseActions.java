package practise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement boxD = driver.findElement(By.xpath("//li[text()='D']"));

		Actions actions = new Actions(driver); 
		actions.moveToElement(boxA);
		actions.clickAndHold(); 
		actions.moveToElement(boxD);
		actions.release().perform();

		// actions.contextClick(boxD);

		// actions.doubleClick(boxD);
		// actions.build().perform();

		/*
		 * driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		 * WebElement draggable = driver.findElement(By.id("draggable")); 
		 * WebElement droppable = driver.findElement(By.id("droppable"));
		 * 
		 * Actions actions = new Actions(driver); 
		 * actions.dragAndDrop(draggable, droppable); 
		 * actions.build().perform();
		 */
		Thread.sleep(2000);
		driver.close();
		System.out.println("Done");

	}

}
