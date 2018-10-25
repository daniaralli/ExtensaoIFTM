package br.edu.iftm.extensaoSTS.resources;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtividadeResourceTest{
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	private String url = "/atividades/1";

	@Before
	public void setup(){
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testaId() throws Exception{
		this.mvc.perform(get(url))
			.andExpect(status().isOk())	
			.andExpect(jsonPath("nome", is("Visita Tecnica GDG 2018")));
	}
	
	@Test
	public void testaNotFound() throws Exception{
		this.mvc.perform(get("/atividades/10"))
			.andExpect(status().isNotFound());
	}
	
	
}
