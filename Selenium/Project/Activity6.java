package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  @Test
  public void dirMenu() {
	  
	  	WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/directory/viewDirectory/reset/1']")).click();
		WebElement header = driver.findElement(By.tagName("h1"));
		System.out.println("Title of the page is : " + header.getText());
		Assert.assertEquals(header.getText(), "Search Directory");
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
