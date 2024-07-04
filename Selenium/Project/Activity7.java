package project;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions action = new Actions(driver);
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.click();
		
		WebElement myInfo = driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewMyDetails']"));
		myInfo.click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1']")).click();
		WebElement addButton = driver.findElement(By.id("addWorkExperience"));
		addButton.click();
		
		WebElement company = driver.findElement(By.id("experience_employer"));
		WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
		WebElement from = driver.findElement(By.id("experience_from_date"));
		WebElement to = driver.findElement(By.id("experience_to_date"));
		
		company.sendKeys("IBM");
		jobTitle.sendKeys("Test Specialist");
		from.clear();
		to.clear();
		from.sendKeys("2022-04-18");
		to.sendKeys("2025-12-31");
		
		WebElement saveButton = driver.findElement(By.id("btnWorkExpSave"));
		saveButton.click();
		
		driver.close();
	}

}
