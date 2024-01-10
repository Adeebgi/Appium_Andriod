package AppiumHybridApp;

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

public class BrowserBaseTest {

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
				options.setChromedriverExecutableDir("D://ForAppiumTestingProject//chromedriver_win32");
				options.setCapability("browserName", "Chrome");
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
	}


	public Double getFormatedAmount(String amont)
	{
		double price=	Double.parseDouble(amont.substring(1));
		return price;
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop(); 
		
	}
}
