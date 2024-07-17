package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

public class OpenPage {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  
		    UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.android.chrome");
			options.setAppActivity("com.google.android.apps.chrome.Main");
			options.noReset();
			
			URL serverURL = new URL("http://localhost:4723/");
			driver= new AndroidDriver(serverURL,options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("https://v1.training-support.net/selenium");
		}
	  
	  @Test
	  public void openPageChrome() {
		  
		  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	      driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
	      driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"To-Do List  Elements get added at run time \"]")).click();
	      wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("taskInput")));
	      driver.findElement(AppiumBy.id("taskInput")).click();
	      driver.findElement(AppiumBy.id("taskInput")).sendKeys("First Task");
	      driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
	      driver.findElement(AppiumBy.id("taskInput")).sendKeys("Second Task");
	      driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
	      driver.findElement(AppiumBy.id("taskInput")).sendKeys("Third Task");
	      driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
	      
	      List<WebElement> taskList = driver.findElements(AppiumBy.xpath("//android.view.View[@text=\"Add more tasks to this list.\"]"));
	      System.out.println("Number of tasks : " + taskList.size());
	      driver.findElement(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]"));
	      
	      Assert.assertEquals(taskList, 3);
	  }
	        
	  
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
