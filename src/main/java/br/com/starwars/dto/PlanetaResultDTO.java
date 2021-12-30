package br.com.starwars.dto;

import java.util.List;

public class PlanetaResultDTO {	
	private List<PlanetaIntegracaoDTO> results;

	public List<PlanetaIntegracaoDTO> getResults() {
		return results;
	}

	public void setResults(List<PlanetaIntegracaoDTO> results) {
		this.results = results;
	}	
	
}
