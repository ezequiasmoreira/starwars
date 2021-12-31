package br.com.starwars.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class PlanetaIntegracaoDTOTest {

	@Test
	public void test() {
		
		String name = "teste-name";
		ArrayList<String> films = new  ArrayList<String>(); 
		films.add("filme 1");
						
		PlanetaIntegracaoDTO dto = new PlanetaIntegracaoDTO();
		dto.setName(name);
		dto.setFilms(films);
		
		assertEquals(dto.getName(), name);
		assertNotNull(dto.getFilms());
	}
}
