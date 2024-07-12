package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleTasks {
	
	AndroidDriver driver;
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  
		    UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.google.android.apps.tasks");
			options.setAppActivity(".ui.TaskListsActivity");
			options.noReset();
			
			URL serverURL = new URL("http://localhost:4723/");
			driver= new AndroidDriver(serverURL,options);
		}
	
  @Test
  public void googleTasks() {
	  
	  driver.findElement(AppiumBy.id("tasks_fab")).click();
	  driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
	  driver.findElement(AppiumBy.id("add_task_done")).click();
	  
	  driver.findElement(AppiumBy.id("tasks_fab")).click();
	  driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
	  driver.findElement(AppiumBy.id("add_task_done")).click();
	  
	  driver.findElement(AppiumBy.id("tasks_fab")).click();
	  driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
	  driver.findElement(AppiumBy.id("add_task_done")).click();
	  
	 // Assert.assertEquals("Complete Activity with Google Tasks", driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\"])[1]")));
		/*
		 * String taskList = driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"My Tasks\"]")).getText();
		 * */
		  //System.out.println("tasks are : " + driver.findElement(AppiumBy.linkText("My Tasks")));
		 
	  
	  //System.out.println("tasks are : " + driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"My Tasks\"]")).getText());
	  
	  String Task1 = driver.findElement(AppiumBy.xpath("	\n"
	  		+ "(//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\"])[1]")).getText();
	  
	  String Task2 = driver.findElement(AppiumBy.xpath("	\n"
		  		+ "(//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\"])[2]")).getText();
	  
	 String Task3 = driver.findElement(AppiumBy.xpath("	\n"
		  		+ "(//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\"])[3]")).getText();
	 
	 Assert.assertEquals(Task1, "Complete the second Activity Google Keep");
	 Assert.assertEquals(Task2, "Complete Activity with Google Keep");
	 Assert.assertEquals(Task3, "Complete Activity with Google Tasks");

	  }
	  


@AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
