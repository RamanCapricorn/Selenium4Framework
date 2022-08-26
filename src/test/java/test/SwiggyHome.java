package test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Argument;

public class SwiggyHome {
	
	WebDriver driver=null;
	public SwiggyHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
		
	}
	
	@FindBy(name = "q")
	public WebElement searchTxt;

	@FindBy(id = "location")
	public WebElement txtLocation;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/button[1]")
//	@FindBy(xpath = "//span[contains(text(),'Pune')]")
	public WebElement LocationResultOption;
	
	@FindBy(xpath = "//a[@href='/restaurants/cakezone-shivaji-nagar-shivajinagar-pune-358620']")
	private WebElement lnkrestaurant;
	
	public void inputSearch(String str) {
		
		searchTxt.sendKeys(str);
	}
	
	public void inputLocation(String str) {
		
		txtLocation.sendKeys(str);
	}
	
	public void clickLocation() throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement loc = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/button[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", loc);
		
//		LocationResultOption.click();
//		String location = LocationResultOption.getText();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		driver.findElement(By.xpath("//button/span[contains(text(),'Pune')]")).click();
//		txtLocation.sendKeys(location);
//		driver.findElement(By.xpath("//a[@class='_3iFC5']")).click();
//		jse.executeScript("argument[0].click();", LocationResultOption);
	}
	
	public void clickRestaurant() throws InterruptedException {
		Thread.sleep(5000);
		lnkrestaurant.click();
	}
}
