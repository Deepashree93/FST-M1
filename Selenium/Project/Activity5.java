package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Activity5 {
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	  
  @Test
  public void editUserInfo() {
	  
	  	WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("btnSave")).click();
		WebElement fullName = driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement lastName = driver.findElement(By.name("personal[txtEmpLastName]"));
		WebElement gender1 = driver.findElement(By.id("personal_optGender_1"));
		WebElement gender2 = driver.findElement(By.id("personal_optGender_2"));
		Select nationality = new Select(driver.findElement(By.name("personal[cmbNation]")));
		WebElement doB = driver.findElement(By.id("personal_DOB"));
		fullName.clear();
		lastName.clear();
		doB.clear();
		fullName.sendKeys("Peter");
		gender1.click();
		nationality.selectByVisibleText("Indian");
		doB.sendKeys("1997-10-05");
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		saveButton.click();
		System.out.println("URL after saving the details is : " + driver.getCurrentUrl());
  }
  

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
	  
  }

}
