package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	  
  @Test
  public void retrieveContacts() {
	  
	  	Actions actions = new Actions(driver);
	  	WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewEmergencyContacts/empNumber/1']")).click();
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='emgContactName']//tr")); 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 
		    	for (WebElement cell : cells) {         
		    		System.out.println(cell.getText());
		    	}
		}
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }
}
