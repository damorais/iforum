package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class BaseE2E {
	public static final String ApplicationBaseURI = "http://localhost:3000";
	
	protected static WebDriver driver = new ChromeDriver();
	
	@Autowired
	private Environment env;
	
	public String getUrlForPath(String path) {
		return String.format("http://localhost:%s%s", env.getProperty("server.port"), path);
	}	
	
	
	public static Map<String, String> pageNameToUrl = new HashMap<String, String>() {
		{
			put("Topicos", "/topicos");
		}
		private static final long serialVersionUID = -8187083082768035176L;
	};
	
	public static Map<String, String> pageAndTitle = new HashMap<String, String>() {
		{
			put("Topicos", "Tópicos");
		}
		
		private static final long serialVersionUID = -7416683244851547946L;		
	};
 
}
