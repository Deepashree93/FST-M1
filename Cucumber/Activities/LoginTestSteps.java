package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	
	@Given("^User is on Login page$")
	public void userIsOnLoginPage() {
		
		driver= new FirefoxDriver();
		driver.get(" https://v1.training-support.net/selenium/login-form");
	}
	
	@When("^User enters username and password$")
	public void userEntersUsernameAndPassword () {
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		loginButton.click();
	}
	
	@Then("^Read the page title and confirmation message$")
	public void readThePageTitleAndConfirmationMessage() {
		
		
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
		
		String title = driver.getTitle();
		System.out.println("Page title is : "+ title);
	}
	
	@And("^Close the Browser$")
	public void closeTheBrowser() {
		driver.close();
	}

}
