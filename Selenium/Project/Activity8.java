package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	  
  @Test
  public void applyLeave() {
	  
	  	Actions actions = new Actions(driver);
	  	WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
		dashboard.click();
		WebElement applyLeave = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png']"));
		applyLeave.click();
		WebElement apply = driver.findElement(By.id("menu_leave_applyLeave"));
		apply.click();
		Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
		leaveType.selectByVisibleText("DayOff");
		fromDate.clear();
		fromDate.sendKeys("2024-07-03");
		toDate.clear();
		toDate.sendKeys("2024-07-05");
		WebElement applyButton = driver.findElement(By.id("applyBtn"));
		actions.moveToElement(applyButton).click();
		WebElement myLeave = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
		myLeave.click();
		WebElement from = driver.findElement(By.id("calFromDate"));
		WebElement to = driver.findElement(By.id("calToDate"));
		from.clear();
		from.sendKeys("2024-07-03");
		to.clear();
		to.sendKeys("2024-07-05");
		WebElement searchButton = driver.findElement(By.id("btnSearch"));
		searchButton.click();
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }
}
