package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class TopicosSteps extends BaseE2E{
	
	@Autowired
	TopicosRepository topicosRepository;
	
	@Entao("eu devo conseguir ver a lista de tópicos cadastrados")
	public void vejo_a_lista_de_topicos() {
		WebElement tabelaTopicos = new WebDriverWait(driver,DefaultWaitTime).until(new ExpectedCondition<WebElement>() {
           public WebElement apply(WebDriver d) {
               return d.findElement(By.id("topicos"));
			}
		});
		
		assertThat(tabelaTopicos).isNotNull();
	}
	
	@Dado("que ha tópicos cadastrados")
	public void ha_topicos_cadastrados(){
		
		//topicosRepository = new TopicosRepository();
		
		Topico topico1 = new Topico();
		topico1.setTitulo("Topico 1");
		topico1.setMensagem("Mensagem Tópico 1");
		
		Topico topico2 = new Topico();
		topico2.setTitulo("Topico 2");
		topico2.setMensagem("Mensagem Tópico 2");
		
		topicosRepository.save(topico1);
		topicosRepository.save(topico2);
		
	}
	
	@Entao("eu consigo visualizar estes tópicos")
	public void consigo_visualizar_topicos(){
		WebElement tabelaTopicos = driver.findElement(By.id("topicos"));
		
		List<WebElement> itensTabela = tabelaTopicos.findElements(By.tagName("tr"));
		assertThat(itensTabela.size()).isEqualTo(3);
	}

	@Quando("eu preencho o formulário com o título {string} e descrição {string}")
	public void preencho_formulario_com_titulo_e_descricao(String titulo, String descricao){
		
		//Espero a página carregar
		new WebDriverWait(driver, DefaultWaitTime)
			.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		
		driver.findElement(By.id("titulo")).sendKeys(titulo);
		driver.findElement(By.id("descricao")).sendKeys(descricao);
	}
	
	@Entao("uma mensagem de sucesso dizendo {string}")
	public void uma_mensagem_de_sucesso_dizendo(String mensagem){
	    throw new cucumber.api.PendingException();
	}

	@Entao("um tópico com o título {string} deve estar visível na lista de tópicos")
	public void um_topico_com_o_titulo_deve_estar_visivel(String titulo){
	    throw new cucumber.api.PendingException();
	}
	
}
