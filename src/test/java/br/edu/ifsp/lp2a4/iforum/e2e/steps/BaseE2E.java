package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class BaseE2E {
	//O Webdriver deve ser estático, para que ele seja acessível pelos passos em sequência
	protected static WebDriver driver;

	@Autowired
	private Environment env;
	
	public String getBaseUrl() {
		return String.format("http://localhost:%s", env.getProperty("server.port"));
	}
	
	public String getUrlForPath(String path) {
		return String.format("%s%s", getBaseUrl(), path);
	}

	
	
	//TODO: Achar uma alternativa mais adequada para esta representação
	public static Map<String, String> pageNameToUrl = new HashMap<String, String>() {
		{
			put("Topicos", "/topicos");
		}
		private static final long serialVersionUID = -8187083082768035176L;
	};
	
	//TODO: Melhorar: Tenho problema com acentos
	public static Map<String, String> pageAndTitle = new HashMap<String, String>() {
		{
			put("Topicos", "Tópicos");
		}
		
		private static final long serialVersionUID = -7416683244851547946L;		
	};
}
