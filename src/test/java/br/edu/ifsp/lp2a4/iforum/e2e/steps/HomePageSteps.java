package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	public static final String ApplicationBaseURI = "http://localhost:8080";
	
	private final WebDriver driver = new FirefoxDriver();
	
	@When("I visit {string}")
	public void I_visit_a_page(String page) {
		String url = ApplicationBaseURI + page;
		
		driver.get(url);
	}
	
	@Then("I should see a {string} message")
	public void I_should_see_a_message(String expectedMessage) {
		
		String result = new WebDriverWait(driver,10L).until(new ExpectedCondition<String>() {
           public String apply(WebDriver d) {
               return d.findElement(By.tagName("body")).getText();
			}
		});
		
		assertTrue(result.contains(expectedMessage));
	}
	
	@After()
	public void closeBrowser() {
		driver.quit();
	}
}
