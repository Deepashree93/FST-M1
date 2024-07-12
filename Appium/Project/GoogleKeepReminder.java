package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class GoogleKeepReminder {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  
		    UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.google.android.keep");
			options.setAppActivity(".activities.BrowseActivity");
			options.noReset();
			
			URL serverURL = new URL("http://localhost:4723/");
			driver= new AndroidDriver(serverURL,options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	  
	  @Test
	  public void googleKeepReminder () {
		  
		  driver.findElement(AppiumBy.id("new_note_button")).click();
		  driver.findElement(AppiumBy.id("editable_title")).sendKeys("Appium");
		  driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Working on Appium Project");
		  driver.findElement(AppiumBy.id("menu_reminder")).click();
		  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]")).click();
		  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"July 13\"]"));
		  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"1:00 PM\"]"));
		  driver.findElement(AppiumBy.xpath("	\r\n"
		  		+ "//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Does not repeat\"]"));
		  driver.findElement(AppiumBy.id("save")).click();
		  String reminder = driver.findElement(AppiumBy.id("reminder_chip")).getText();
		  
		  System.out.println("reminder is : " + reminder);

		  String title = driver.findElement(AppiumBy.id("index_note_title")).getText();
		  String desc = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
		  
		  Assert.assertEquals("Appium", title);
		  Assert.assertEquals("Working on Appium Project", desc);
		  Assert.assertEquals("Tomorrow, 1:00 PM", reminder);
 
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
