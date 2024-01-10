package alaacademy.appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest{
	@Test
	
	public void SwipeDemoTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		
		WebElement firstImage=driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
		
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
		
		//Swipe
		SwipeActions(firstImage, "left");
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
	}
	
		
		
}
