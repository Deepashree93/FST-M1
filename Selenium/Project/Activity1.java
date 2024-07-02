package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		if(title.equals("OrangeHRM")) {
			System.out.println("Title matches exactly");
			driver.close();
		}
		else {
		System.out.println("Title mismatch");
		}
	}

}
