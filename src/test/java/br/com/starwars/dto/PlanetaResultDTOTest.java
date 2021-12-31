package br.com.starwars.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PlanetaResultDTOTest {
	
	private List<PlanetaIntegracaoDTO> results;

	@Test
	public void test() {
		
		PlanetaResultDTO dto = new PlanetaResultDTO();
		dto.setResults(new ArrayList<PlanetaIntegracaoDTO>());
		assertNotNull(dto.getResults());
	}
}
