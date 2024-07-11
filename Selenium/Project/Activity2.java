package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  
  }
  
  @Test
  public void headerUrl() {
	  
	  WebElement headerImage = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/"
				+ "themes/default/images/login/logo.png']"));
		
		String src = headerImage.getAttribute("src");
		
		System.out.println("Header image url is " + src);
	  
  }
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
