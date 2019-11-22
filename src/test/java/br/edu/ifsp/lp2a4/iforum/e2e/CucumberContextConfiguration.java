package br.edu.ifsp.lp2a4.iforum.e2e;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import io.cucumber.java.Before;


import br.edu.ifsp.lp2a4.iforum.IforumApplication;

@SpringBootTest(classes = IforumApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ContextConfiguration
public class CucumberContextConfiguration {
	@Before
	public void setUp() {
		
	}
}
