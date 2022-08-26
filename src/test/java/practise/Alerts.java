package practise;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		if(driver.getPageSource().contains("You successfully clicked an alert"))
			System.out.println("You successfully clicked an alert");
		System.out.println("=====================================");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert confirm = driver.switchTo().alert();
		System.out.println(confirm.getText());
		confirm.dismiss();
		if(driver.getPageSource().contains("You clicked: Cancel"))
			System.out.println("You clicked: Cancel");
		System.out.println("=====================================");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert prompt = driver.switchTo().alert();
		System.out.println(prompt.getText());
		prompt.sendKeys("Raman");
		prompt.accept();
		if(driver.getPageSource().contains("You entered: Raman"))
			System.out.println("You entered: Raman");
		System.out.println("=====================================");
		
		Thread.sleep(2000);
		
		driver.close();
	}
}
