package br.com.starwars.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.starwars.dto.PlanetaIntegracaoDTO;
import br.com.starwars.dto.PlanetaResultDTO;

public class PlanetaTest {
	
	private Integer id = 1;
	
	private String nome = "teste-nome";
	
	private String clima = "teste-clima";
	
	private String terreno = "teste-terreno";
	

	@Test
	public void test() {
		
		Planeta planeta = new Planeta();
		
		planeta.setId(1);
		planeta.setNome(nome);
		planeta.setClima(clima);
		planeta.setTerreno(terreno);
		
		assertEquals(planeta.getId(), 1);
		assertEquals(planeta.getNome(), nome);
		assertEquals(planeta.getClima(), clima);
		assertEquals(planeta.getTerreno(), terreno);
	}
	
	@Test
	public void test_aparicao_fimes() {
		
		Planeta planeta = new Planeta();
		ArrayList<String> films = new  ArrayList<>();
		ArrayList<PlanetaIntegracaoDTO> results = new  ArrayList<>();
		
		films.add("filme 1");
		films.add("filme 2");
		films.add("filme 3");
		
		PlanetaIntegracaoDTO planetaIntegracaoDTO = new PlanetaIntegracaoDTO();
		planetaIntegracaoDTO.setFilms(films);
		planetaIntegracaoDTO.setName(nome);
		results.add(planetaIntegracaoDTO);
		
		PlanetaResultDTO planetaResultDTO = new PlanetaResultDTO();
		planetaResultDTO.setResults(results);
		
		planeta.setAparicaoFilme(planetaResultDTO);		
		assertNull(planeta.getAparicaoFilme());
		
		planeta.setNome(nome);
		planeta.setAparicaoFilme(planetaResultDTO);	
		assertEquals(planeta.getAparicaoFilme(), 3);
	}
}
