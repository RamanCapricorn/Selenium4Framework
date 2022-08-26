package practise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webElementDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// find element
//		driver.get("https://google.com");
//		driver.findElement(By.name("q")).sendKeys("Cypress Tutorials", Keys.ENTER);
		
		// find elements
		/*
		driver.get("https://trytestingthis.netlify.app/");
		List<WebElement> elements = driver.findElements(By.tagName("select"));
		
		for(WebElement element : elements) {
			System.out.println(element.getText());
		}
		*/
		
		/*
		 * // find element within element 
		 * driver.get("https://google.com");
		 * 
		 * WebElement form = driver.findElement(By.tagName("form"));
		 * form.findElement(By.name("q")).sendKeys("Cypress Tutorials", Keys.ENTER);
		 */
		
		/*
		 * // find element 
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("Cypress Tutorials"); 
		 * String title = driver.switchTo().activeElement().getAttribute("title");
		 * System.out.println(title);
		 */
		/*
		 * // Get Tagname, text, css etc. 
		 * driver.get("https://google.com"); 
		 * WebElement searchBox = driver.findElement(By.name("q")); 
		 * String tagName = searchBox.getTagName(); 
		 * String text = searchBox.getText(); 
		 * String cssValue = searchBox.getCssValue("font"); 
		 * System.out.println(tagName + " | " + text + " | " + cssValue);
		 */
		
		// Check element is Enabled/selected
		driver.get("https://the-internet.herokuapp.com/checkboxes"); 
		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		System.out.println(checkBox.isEnabled());
		System.out.println(checkBox.isSelected());
		
		Thread.sleep(2000);
		driver.close();

	}

}

// https://trytestingthis.netlify.app/