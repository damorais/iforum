package br.edu.ifsp.lp2a4.iforum.unit.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import br.edu.ifsp.lp2a4.iforum.controllers.TopicosController;
import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;

public class TopicosControllerTests {
		
	@Test
	public void deve_retornar_um_template_de_lista_de_topicos() {
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		
		TopicosController controller = new TopicosController(repository);
		
		ModelAndView resultado = controller.list();
		
		assertThat(resultado.getViewName()).isEqualTo("topicos/list");
	}
	
	@Test
	public void deve_retornar_uma_lista_de_topicos() {
		
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		List<Topico> expectedTopicsList = Arrays.asList(new Topico(), new Topico());
		
		when(repository.findAll()).thenReturn(expectedTopicsList);
		
		TopicosController controller = new TopicosController(repository);
		
		ModelAndView resultado = controller.list();
		
		@SuppressWarnings("unchecked")
		List<Topico> topicosRetornados = (List<Topico>)resultado.getModelMap().get("topicos");
		
		assertThat(topicosRetornados.size()).isEqualTo(expectedTopicsList.size());		
	}
	
	@Test
	public void deve_retornar_um_template_de_criacao_de_topico() {
		
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		
		TopicosController controller = new TopicosController(repository);
		
		ModelAndView resultado = controller.create();
		
		assertThat(resultado.getViewName()).isEqualTo("topicos/create");
	}
	
	@Test
	public void ao_criar_deve_redirecionar_para_a_lista_de_topicos() {
		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
		
		TopicosController controller = new TopicosController(repository);
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		
		Topico topico = new Topico("Um topico qualquer", "Exemplo de tópico");
		
		ModelAndView resultado = controller.create(topico, redirectAttributes);
		
		assertThat(resultado.getViewName()).isEqualTo("redirect: /topicos");
	}

//	@Test
//	public void ao_criar_deve_redirecionar_com_mensagem_de_sucesso() {
//		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
//		
//		TopicosController controller = new TopicosController(repository);
//		
//		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
//		
//		Topico topico = new Topico("Um topico qualquer", "Exemplo de tópico");
//		
//		//Não preciso do resultado, uma vez que eu mexo no mesmo elemento passado
//		//como atributo
//		controller.create(topico, redirectAttributes);
//		
//		assertThat(redirectAttributes.getFlashAttributes().containsKey("sucesso")).isTrue();
//		assertThat(redirectAttributes.getFlashAttributes().get("sucesso")).isEqualTo("Tópico criado");
//	}
//	
//	@Test
//	public void deve_permanecer_no_template_quando_invalido() {
//		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
//		
//		TopicosController controller = new TopicosController(repository);
//		
//		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
//		
//		Topico topico = new Topico("Um topico qualquer", "Exemplo de tópico");
//		
//		//Não preciso do resultado, uma vez que eu mexo no mesmo elemento passado
//		//como atributo
//		controller.create(topico, redirectAttributes);
//		
//		assertThat(redirectAttributes.getFlashAttributes().containsKey("sucesso")).isTrue();
//		assertThat(redirectAttributes.getFlashAttributes().get("sucesso")).isEqualTo("Tópico criado");
//	}
	
	
	
	
//	@Test
//	public void deve_retornar_lista_vazia_quando_nao_ha_topicos() {
//		TopicosRepository repository = Mockito.mock(TopicosRepository.class);
//		when(repository.findAll()).thenReturn(null);
//		
//		TopicosController controller = new TopicosController(repository);
//		
//		ModelAndView resultado = controller.list();
//		
//		@SuppressWarnings("unchecked")
//		List<Topico> topicosRetornados = (List<Topico>)resultado.getModelMap().get("topicos");
//		
//		assertThat(topicosRetornados.size()).isEqualTo(0);
//	}
	
}
