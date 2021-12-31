package br.com.starwars.integracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.starwars.dto.PlanetaResultDTO;

public class PlanetaIntegracaoTest {
	
	@Test
	public void test() {
		
		PlanetaIntegracao planetaIntegracao = new PlanetaIntegracao();
		PlanetaResultDTO result = planetaIntegracao.getPlanetasStarWars();
		assertTrue(result.getResults().size() > 0);
	}
}
