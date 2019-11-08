package br.edu.ifsp.lp2a4.iforum.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifsp.lp2a4.iforum.controllers.TopicosController;


@SpringBootTest
class IforumApplicationTests {

	@Autowired
	private TopicosController topicosController;
	
	
	@Test
	void contextLoads() {
		
		assertThat(topicosController).isNotNull();
		
	}

}
