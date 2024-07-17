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

public class TestLoginPage {
	
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
	  public void testLoginPage() {
		  
		  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		  wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
		  driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Login Form  Please sign in. \")")).click();
	      //driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + "scrollIntoView(UiSelector)"));
	      //driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"")).click();
	      driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form  Please sign in. \"]")).click();
	      driver.findElement(AppiumBy.id("username")).sendKeys("admin");
	      driver.findElement(AppiumBy.id("password")).sendKeys("password");
	      driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
	      
	      String successMessage = driver.findElement(AppiumBy.id("action-confirmation")).getText();
	      String failureMessage = driver.findElement(AppiumBy.id("action-confirmation")).getText();
	      if(successMessage.equals("Welcome Back, admin")) {
	    	  
	    	  System.out.println("Successful login");
	      }
	      else if (failureMessage.equals("Invalid Credentials")) {
	    	  
	    	  System.out.println("Unable to login, invalid credentials");
	      }
	      
	      Assert.assertEquals("Welcome Back, admin", successMessage);
	      Assert.assertEquals("Invalid Credentials", failureMessage);
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
