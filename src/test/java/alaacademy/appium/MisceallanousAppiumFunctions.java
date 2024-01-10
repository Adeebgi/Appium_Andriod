package alaacademy.appium;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MisceallanousAppiumFunctions extends BaseTest{
	
	@Test
	public void Miscellanous() throws MalformedURLException, InterruptedException
	{
		

		//App Pacakge & App Activity ; doing this, I want to go directly to the page
		//create object of ActivityClass
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//((Object) driver).startActivity(activity);
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		//LandsScape mode 
		
		DeviceRotation landScape= new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String tittle=	driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(tittle, "WiFi settings");
		
		//copy paste
		//copy to clipboard-paste it clipboard
		
		driver.setClipboardText("WiFi settings");//this one like a copy 
		//driver.getClipboardText() is written inside sendKey() uses for paste
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));// it press the Enter means control goes on second line
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//press keys 
		driver.pressKey(new KeyEvent(AndroidKey.BACK));//it press the back key
		driver.pressKey(new KeyEvent(AndroidKey.HOME));// it press the home key
		
		
		
	}
	

}
