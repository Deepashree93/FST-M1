package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		
		WebElement loginButton = driver.findElement(By.name("Submit"));
		
		loginButton.click();
		
		WebElement pimId = driver.findElement(By.id("menu_pim_viewPimModule"));
		pimId.click();
	
		WebElement addButton = driver.findElement(By.id("btnAdd"));
	
		
		addButton.click();
		
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
		
		actions.moveToElement(searchButton).click().build().perform();
		
		driver.close();
		
		

	}

}
