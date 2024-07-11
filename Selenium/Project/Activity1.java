package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
  @Test
  public void verifyTitle() {
	  
	  String title = driver.getTitle();
		System.out.println("Title is : " + title);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }
  
  
}
