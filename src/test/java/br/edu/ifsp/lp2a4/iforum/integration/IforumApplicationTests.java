package br.edu.ifsp.lp2a4.iforum.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.edu.ifsp.lp2a4.iforum.controllers.TopicosController;


@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@TestPropertySource(locations="classpath:test.properties")
class IforumApplicationTests {

	@Autowired
	private TopicosController topicosController;
	
	
	@Test
	void contextLoads() {
		
		assertThat(topicosController).isNotNull();
		
	}

}
