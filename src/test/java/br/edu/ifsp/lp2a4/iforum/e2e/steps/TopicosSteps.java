package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class TopicosSteps extends BaseE2E{
	
	TopicosRepository topicosRepository;
	
	@Entao("eu devo conseguir ver a lista de topicos cadastrados")
	public void vejo_a_lista_de_topicos() {
		
		System.out.println("---------------------" + driver.getCurrentUrl());
		System.out.println("---------------------" + driver.getPageSource());
		
		WebElement tabelaTopicos = new WebDriverWait(driver,10L).until(new ExpectedCondition<WebElement>() {
           public WebElement apply(WebDriver d) {
               return d.findElement(By.id("topicos"));
			}
		});
		
		assertThat(tabelaTopicos).isNotNull();
	}
	
	@Dado("que ha topicos cadastrados")
	public void ha_topicos_cadastrados(){
		
		topicosRepository = new TopicosRepository();
		
		Topico topico1 = new Topico();
		topico1.setTitulo("Topico 1");
		topico1.setMensagem("Mensagem Tópico 1");
		
		Topico topico2 = new Topico();
		topico2.setTitulo("Topico 2");
		topico2.setMensagem("Mensagem Tópico 2");
		
		topicosRepository.save(topico1);
		topicosRepository.save(topico2);
		
	}
	
}
