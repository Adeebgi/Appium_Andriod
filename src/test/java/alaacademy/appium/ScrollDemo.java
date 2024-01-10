package alaacademy.appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{
	@Test
	
	public void ScrollDemoTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//If you know the element to scroll use this shortcut 
		//First Way to use shortcut: Use UiAutomator locator you rely on google engine 
	/*	driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	

		Thread.sleep(2000);*/
		
		
		
		// use this, when you dont knwo where to scroll 
		// Second way to USe Appium Documentation 
		ScrolTilltoEndActions();
		
		 
	}
	
		
		
}
