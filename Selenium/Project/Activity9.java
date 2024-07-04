package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {

	public static void main(String[] args) {
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
		
		WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
		myInfo.click();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewEmergencyContacts/empNumber/1']")).click();
		
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='emgContactName']//tr")); 

		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    for (WebElement cell : cells) {         

		    System.out.println(cell.getText());
		    
		    driver.close();
		    
	}

}
	}
}
