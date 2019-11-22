package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CommonSteps {
	
	public static WebDriver driver;
	
	@Before
	public void startWebDriver() {
		driver = new ChromeDriver();
	}
	
	@Quando("eu visito {string}")
	public void quando_eu_visito(String url){
		
		String enderecoCompleto = "http://localhost:3000" + url;
		
		driver.get(enderecoCompleto);
	}

	@Entao("eu devo ver uma mensagem dizendo {string}")
	public void eu_devo_ver_uma_mensagem_dizendo(String mensagem){
		
		String resultado = new WebDriverWait(driver, 10L).until(new ExpectedCondition<String>() {
			public String apply(WebDriver d) {
				return driver.findElement(By.tagName("body")).getText();
			}
		});
		
		assertThat(resultado).contains(mensagem);
	}
	
	@After
	public void closeWebDriver() {
		if(driver != null) {
			driver.close();
			driver.quit();
		}
	}
}