package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Google Home Page$")
	public void userIsOnGooglePage() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void userTypesInCheeseAndHitsEnter() {
		
		driver.findElement(By.name("q")).sendKeys("Cheese",Keys.RETURN);
	}

	@Then("^Show how many search results were shown$")
	public void showSearchResults() {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
		String result = driver.findElement(By.id("result-stats")).getText();
		System.out.println("NUmber of results : " + result);
	}
	
	@And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
	}
}
