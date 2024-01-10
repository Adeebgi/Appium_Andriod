package AppiumHybridApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import alaacademy.appium.BaseTest;
import io.appium.java_client.AppiumBy;

public class eCommerce_Hybird_TC_4 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mesbah");
		// to hide the keyboard
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();

		for (int i = 0; i < productCount; i++) {
			
		
		 driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
		}
		

		Thread.sleep(3000);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.attributeContains(
		 * driver.findElement(AppiumBy.id(
		 * "com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		 */
		 		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		List<WebElement> productPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
		int productList = productPrices.size();
		double totalSum = 0;

		for (int i = 0; i < productList; i++) {
			String amont = productPrices.get(i).getText();
			// string cant be sumed so we need to remove $
			//amont.substring(1);
			// convert string into double
			double price = Double.parseDouble(amont.substring(1));
			totalSum = totalSum + price;// it counts
		}
		String display = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	double displaySum=	getFormatedAmount(display);
	
	Assert.assertEquals(totalSum, displaySum);
	Thread.sleep(3000);
	WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	LongPressActions(ele);
	driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	//if you want to continue your execution in hybrid app, you need to switch the context to the browser
	
	}

}
