package br.edu.ifsp.lp2a4.iforum.unit.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a4.iforum.controllers.TopicosController;
import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;

public class TopicosControllerTests {
	
	@Test
	public void deve_retornar_um_template_de_lista_de_topicos() {
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		
		//Configuração
		TopicosController controller = new TopicosController();
		
		//Execução
		ModelAndView resultado = controller.list(repository);
		
		//Verificação
		assertThat(resultado.getViewName()).isEqualTo("topicos/list");
	}
	
	@Test
	public void deve_retornar_uma_lista_de_topicos() {
		//Configuração
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		List<Topico> expectedTopicsList = Arrays.asList(new Topico(), new Topico());
		
		when(repository.findAll()).thenReturn(expectedTopicsList);
		
		TopicosController controller = new TopicosController();
		//Execução
		ModelAndView resultado = controller.list(repository);
		
		//Verificação
		@SuppressWarnings("unchecked")
		List<Topico> topicosRetornados = (List<Topico>)resultado.getModelMap().get("topicos");
		
		assertThat(topicosRetornados.size()).isEqualTo(expectedTopicsList.size());		
	}
}
