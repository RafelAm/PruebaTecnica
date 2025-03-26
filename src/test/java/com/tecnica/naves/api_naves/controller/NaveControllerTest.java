package com.tecnica.naves.api_naves.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnica.naves.api_naves.model.Nave;
import com.tecnica.naves.api_naves.repository.NaveRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class NaveControllerTest {

    @Autowired
	private MockMvc mockMvc;
	
	@Autowired
	 NaveRepository naveRepository;
	
    @BeforeEach
    void init(){
        Nave nave = new Nave("X-Wing");
        naveRepository.save(nave);
        Nave nave2 = new Nave("Y-Wing");
        naveRepository.save(nave2);
        Nave nave3 = new Nave("Z-Wing");
        naveRepository.save(nave3);

    }
    @AfterEach
    void delAll(){
        naveRepository.deleteAll(naveRepository.findAll());
    }


    @Test
    
    void testCreateNave() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		Nave nave = new Nave("Marvin");
		
		mockMvc.perform(post("/naves")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(nave))
				
				)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", notNullValue()))
			.andExpect(jsonPath("$.name", is("Marvin")));
    }

    @Test
    void testDeleteNaveById() throws Exception {
        mockMvc.perform(delete("/naves/{id}",1))
        .andExpect(status().isOk());
    }

    /*@Test
    void testGetAllNaves() throws Exception {
        mockMvc.perform(get("/naves/{id}" , 1)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name", is("X-Wing")));
    }*/

    @Test
    void testSearchNaveById() throws Exception{
        mockMvc.perform(get("/naves/{id}",1))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name",is("X-Wing")));
    }
}
