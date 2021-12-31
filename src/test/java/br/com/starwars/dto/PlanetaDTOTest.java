package br.com.starwars.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetaDTOTest {
	
	@Test
	public void test() {
		
		String nome = "teste-nome";
		String clima = "teste-clima";
		String terreno = "teste-terreno";
				
		PlanetaDTO dto = new PlanetaDTO();	
		dto.setId(1);
		dto.setNome(nome);
		dto.setClima(clima);
		dto.setTerreno(terreno);
		
		assertEquals(dto.getId(), 1);
		assertEquals(dto.getNome(), nome);
		assertEquals(dto.getClima(), clima);
		assertEquals(dto.getTerreno(), terreno);
	}

}
