package alaacademy.appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	@Test
	
	public void LongPress() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click(); 
		//for doing long click go an appium github gesture documentation 
		WebElement ele=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		LongPressActions(ele);
  
	String menuText=	driver.findElement(AppiumBy.id("android:id/title")).getText();
	Assert.assertEquals(menuText, "Sample menu");
	Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
	}

}
