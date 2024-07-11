package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Activity4 {
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  Actions actions = new Actions(driver);
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	  
  @Test
  public void addEmp() {
	  
	    WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		WebElement pimId = driver.findElement(By.id("menu_pim_viewPimModule"));
		pimId.click();
		driver.findElement(By.id("btnAdd")).click();
		WebElement fullName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		fullName.sendKeys("John");
		lastName.sendKeys("K");
		saveButton.click();
		driver.navigate().back();
		System.out.println("Title is : " +  driver.getTitle());
		driver.navigate().back();
		WebElement empName = driver.findElement(By.id("empsearch_employee_name_empName"));
		WebElement id = driver.findElement(By.id("empsearch_id"));
		empName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		id.clear();
		empName.sendKeys("John");
		WebElement searchButton = driver.findElement(By.id("searchBtn"));
		searchButton.click();
		/*
		 * Actions actions = null;
		 * actions.moveToElement(searchButton).click().build().perform();
		 */
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
