package br.edu.ifsp.lp2a4.iforum.integration.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureMockMvc
public class TopicosControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private TopicosRepository repository;
	
	@Test
    public void deve_listar_topicos_cadastrados() throws Exception {
        
		Iterable<Topico> topicos = Arrays.asList(new Topico("Topico 1", "Blablabla"), new Topico("Topico 2", "Blablabla2"));
		
		when(repository.findAll()).thenReturn(topicos);
		
		this.mockMvc
        	.perform(get("/topicos"))
        	.andExpect(status().isOk())
        	.andExpect(view().name("topicos/list"))
        	.andExpect(model().attribute("topicos", is(topicos)));
    }
	
	@Test
	public void deve_retornar_pagina_de_cadastro() throws Exception {
		this.mockMvc
	    	.perform(get("/topicos/create"))
	    	.andExpect(status().isOk())
	    	.andExpect(view().name("topicos/create"));
	}
}
