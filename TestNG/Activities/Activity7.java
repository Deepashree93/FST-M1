package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {
	
	WebDriver driver ;
	
  @Test(dataProvider = "Authentication")
  public void loginTestCase(String username, String password) {
      //Find username and pasword fields
      WebElement usernameField = driver.findElement(By.id("username"));
      WebElement passwordField = driver.findElement(By.id("password"));
      
      //Enter values
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      
      //Click Log in
      driver.findElement(By.cssSelector("button[type='submit']")).click();
      
      //Assert Message
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals(loginMessage, "Welcome Back, admin");
  }

  public void da() {
  }
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  
	  driver.get("https://v1.training-support.net/selenium/login-form");
	  
  }
  @DataProvider(name = "Authentication")
  public static Object[][] credentials() {
      return new Object[][] { { "admin", "password" }};
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}