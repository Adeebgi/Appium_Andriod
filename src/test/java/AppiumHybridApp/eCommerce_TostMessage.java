package AppiumHybridApp;

import org.testng.Assert;
import org.testng.annotations.Test;

import alaacademy.appium.BaseTest;
import io.appium.java_client.AppiumBy;

public class eCommerce_TostMessage extends BaseTest{
	
	@Test
	public void fillForm() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//to handle toast message, we can use xpath, it definitly has a tag name //android.widget.Toast
		//get the message of toast with using getAttribute function
	String toastMessage=	driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Thread.sleep(3000);
		
		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
