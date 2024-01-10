package alaacademy.appium;

import org.openqa.selenium.remote.HttpCommandExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic extends BaseTest{
	
	@Test
	public void WifiSettingName() throws MalformedURLException, InterruptedException
	{
		

		//Appium Locator
		//xpaht, id, accessibilityId, classname, androidUIAutomator 
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String tittle=	driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(tittle, "WiFi settings");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("AdeebWifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	}
	

}
