package AppiumHybridApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest()
	{
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		System.out.println(driver.getCurrentUrl());
		//driver.findElement(By.name("q")).sendKeys("Adeeb Learning Academy");
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[href$='angularAppdemo/products']")).click();
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
	String text=driver.findElement(By.cssSelector("a[href$='/angularAppdemo/products/3']")).getText();
	driver.findElement(By.cssSelector("a[href$='/angularAppdemo/products/3']")).click();
	
	Assert.assertEquals(text, "Devops");
 
		
	}

}
