package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CommonSteps extends BaseE2E {
	
	public static Map<String, String> pageAndPath = new HashMap<String, String>() {
		{
			put("Topicos", "/topicos");
		}
		private static final long serialVersionUID = -8187083082768035176L;
	};
	
	@Quando("eu acesso a pagina {string}")
	public void eu_acesso_a_pagina(String pagina) {
		String url = getUrlForPath(BaseE2E.pageNameToUrl.get(pagina)); 
	
		System.out.println(url);
		
		driver.get(url);
		
		assertTrue(driver.getTitle().contains(pagina));
	}
	
	@Quando("eu clico no link {string}")
	public void eu_clico_no_link(String linkText){
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
	
	

	@Quando("eu visito {string}")
	public void eu_visito(String pageUrl) {
		String url = getUrlForPath(pageUrl);
		
		driver.get(url);
	}
	
	@Quando("eu estou na pagina {string}")
	public void eu_estou_na_pagina(String nomePagina) {
		String url  = getUrlForPath(pageAndPath.get(nomePagina));
		
		driver.get(url);
		
		assertTrue(driver.getTitle().contains(nomePagina));
	}
	
	@Entao("eu devo ver uma mensagem dizendo {string}")
	public void eu_devo_ver_a_mensagem(String expectedMessage) {
		
		String result = new WebDriverWait(driver,10L).until(new ExpectedCondition<String>() {
           public String apply(WebDriver d) {
               return d.findElement(By.tagName("body")).getText();
			}
		});
		
		assertTrue(result.contains(expectedMessage));
	}
	
	@Entao("eu devo ser direcionado para a pagina {string}")
	public void eu_devo_ser_redirecionado_para(String string){
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
	
	@After()
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}