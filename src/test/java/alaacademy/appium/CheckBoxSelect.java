package alaacademy.appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class CheckBoxSelect extends BaseTest{
	@Test
	
	public void CheckBoxSelect() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']")).click();
		//verify the OptionSelected
		
	Assert.assertEquals(driver.findElement(AppiumBy.xpath(
			"//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']")).getAttribute("text"), "Satellite");	
		
		driver.findElement(AppiumBy.id("android:id/button1")).click(); 
 	}
	
		
		
}
