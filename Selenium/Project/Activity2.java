package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		WebElement headerImage = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/"
				+ "themes/default/images/login/logo.png']"));
		
		String src = headerImage.getAttribute("src");
		
		System.out.println("Header image is " + src);
		
		driver.close();
	}

}
