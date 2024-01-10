package alaacademy.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void ConfigureAppuim() throws MalformedURLException
	{
		
		//create object of AndroidDriver 
				//it needs to argument, First AppiumServer and Capabilities 
				 service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//adeeb//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
						 .withIPAddress("127.0.0.1").usingPort(4723).build();
				 
				 //Thread.sleep(50000); 
				service.start();
				 
				
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Komail");
				//options.setApp("D://ForAppiumTestingProject//appium//src//test//java//Utilities//ApiDemos-debug.apk");
				options.setApp("D://ForAppiumTestingProject//appium//src//test//java//Utilities//General-Store.apk");
				options.setChromedriverExecutableDir("D://ForAppiumTestingProject//chromedriver_win32");


		
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
	}
	
	public void LongPressActions(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration",2000));
		
	}
	
	public void ScrolTilltoEndActions()
	{
		boolean canScrollMore;
		do
		{
	 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	public void SwipeActions(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement)ele).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
			
	
	}
	
	public Double getFormatedAmount(String amont)
	{
		double price=	Double.parseDouble(amont.substring(1));
		return price;
	}
	
	public void DragAndDropAction(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 631,
			    "endY", 501
			));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop(); 
		
	}
}
