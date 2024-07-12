package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class GoogleKeep {
	
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
	  public void googleKeep() {
		  
		  driver.findElement(AppiumBy.id("new_note_button")).click();
		  driver.findElement(AppiumBy.id("editable_title")).sendKeys("Appium");
		  driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Working on Appium Project");
		  wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
		  driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		  
		  String title = driver.findElement(AppiumBy.id("index_note_title")).getText();
		  String desc = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
		  
		  System.out.println("Title is : " + title);
		  System.out.println("Description is : " + desc);
		  
		  Assert.assertEquals("Appium", title);
		  Assert.assertEquals("Working on Appium Project", desc);
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
