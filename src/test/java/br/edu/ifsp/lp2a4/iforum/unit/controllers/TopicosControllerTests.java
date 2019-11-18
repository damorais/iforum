package br.edu.ifsp.lp2a4.iforum.unit.controllers;

import static org.assertj.core.api.Assertions.*;
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
		
		TopicosController controller = new TopicosController();
		
		ModelAndView resultado = controller.list(repository);
		
		assertThat(resultado.getViewName()).isEqualTo("topicos/list");
	}
	
	@Test
	public void deve_retornar_uma_lista_de_topicos() {
		
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		List<Topico> expectedTopicsList = Arrays.asList(new Topico(), new Topico());
		
		when(repository.findAll()).thenReturn(expectedTopicsList);
		
		TopicosController controller = new TopicosController();
		
		ModelAndView resultado = controller.list(repository);
		
		@SuppressWarnings("unchecked")
		List<Topico> topicosRetornados = (List<Topico>)resultado.getModelMap().get("topicos");
		
		assertThat(topicosRetornados.size()).isEqualTo(expectedTopicsList.size());		
	}
	
	@Test
	public void deve_retornar_lista_vazia_quando_nao_ha_topicos() {
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		when(repository.findAll()).thenReturn(null);
		
		TopicosController controller = new TopicosController();
		
		ModelAndView resultado = controller.list(repository);
		
		@SuppressWarnings("unchecked")
		List<Topico> topicosRetornados = (List<Topico>)resultado.getModelMap().get("topicos");
		
		assertThat(topicosRetornados.size()).isEqualTo(0);
	}
	
}
