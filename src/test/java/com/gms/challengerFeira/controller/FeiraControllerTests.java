package com.gms.challengerFeira.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URLEncoder;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.nio.charset.StandardCharsets;

import com.gms.challengerFeira.entity.Feira;
import com.gms.challengerFeira.repository.FeiraRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class FeiraControllerTests {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private FeiraRepository feiraRepository;
	
	
	@Test
	void testarCadastroFeira() throws Exception {
		URI uri = new URI("/feiras");
		String json = "{\"longi\":\"-46550888\",\"lat\":\"-23558788\",\"setcens\":\"355030885000091\",\"areaP\":\"3550308005040\",\"codDist\":\"87\",\"distrito\":\"VILA FORMOSA\",\"codSubPref\":\"26\",\"subPrefe\":\"ARICANDUVA-FORMOSA-CARRAO\",\"regiao5\":\"Leste\",\"regiao8\":\"Leste 1\",\"nomeFeira\":\"VILA FORMOSA\",\"registro\":\"4041-0\",\"logradouro\":\"RUA MARAGOJIPE\",\"numero\":\"110\",\"bairro\":\"VL FORMOSA\",\"referencia\":\"TV RUA GLOBO\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.post(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	
	@Test
	void testarBuscaFeiraPorDistrito() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/search?distrito="+URLEncoder.encode(feiras.get(0).getDistrito(), StandardCharsets.UTF_8));
		String json = "{}";
		 mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarBuscaFeiraPorRegiao5() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/search?regiao5="+URLEncoder.encode(feiras.get(0).getRegiao5(), StandardCharsets.UTF_8));
		String json = "{}";
		 mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarBuscaFeiraPorNomeFeira() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/search?nomeFeira="+URLEncoder.encode(feiras.get(0).getNomeFeira(), StandardCharsets.UTF_8));
		String json = "{}";
		 mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarBuscaFeiraPorBairro() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/search?bairro="+URLEncoder.encode(feiras.get(0).getBairro(), StandardCharsets.UTF_8));
		String json = "{}";
		 mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarBuscaFeiraPorDistritoOuRegiao5OuNomeFeiraOuBairro() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 1);
		URI uri = new URI("/feiras/search?distrito="+URLEncoder.encode(feiras.get(0).getDistrito(), StandardCharsets.UTF_8)+"&regiao5="+URLEncoder.encode(feiras.get(1).getRegiao5(), StandardCharsets.UTF_8)+"&nomeFeira="+URLEncoder.encode(feiras.get(0).getNomeFeira(), StandardCharsets.UTF_8)
				          +"&bairro="+URLEncoder.encode(feiras.get(1).getBairro(), StandardCharsets.UTF_8));
		String json = "{}";
		 mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarAtualizacaoFeira() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/"+feiras.get(0).getId());
		String json = "{\"longi\":\""+feiras.get(0).getLongi()+"\","
				     + "\"lat\":\""+feiras.get(0).getLat()+"\","
				     + "\"setcens\":\""+feiras.get(0).getSetcens()+"\","
				     + "\"areaP\":\""+feiras.get(0).getAreaP()+"\","
				     + "\"codDist\":\""+feiras.get(0).getCodDist()+"\","
				     + "\"distrito\":\""+feiras.get(0).getDistrito()+"\","
				     + "\"codSubPref\":\""+feiras.get(0).getCodSubPref()+"\","
				     + "\"subPrefe\":\""+feiras.get(0).getSubPrefe()+"\","
				     + "\"regiao5\":\""+feiras.get(0).getRegiao5()+"\","
				     + "\"regiao8\":\""+feiras.get(0).getRegiao8()+"\","
				     + "\"nomeFeira\":\""+feiras.get(0).getNomeFeira()+"\","
				     + "\"registro\":\""+feiras.get(0).getRegistro()+"\","
				     + "\"logradouro\":\""+feiras.get(0).getLogradouro()+"\","
				     + "\"numero\":\""+feiras.get(0).getNumero()+"\","
				     + "\"bairro\":\""+feiras.get(0).getBairro()+"\","
				     + "\"referencia\":\""+feiras.get(0).getReferencia()+"\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.put(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	void testarExclusaoFeira() throws Exception {
		List<Feira> feiras = feiraRepository.findAll();
		assertTrue(feiras.size() > 0);
		URI uri = new URI("/feiras/"+feiras.get(0).getId());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.delete(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}

}
