package br.com.starwars.integracao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.starwars.dto.PlanetaResultDTO;

@Service
public class PlanetaIntegracao {
	private static final String PATH_API = "https://swapi.dev/api/";
	
	public PlanetaResultDTO getPlanetasStarWars() {
		RestTemplate restTemplate = new RestTemplate();
		PlanetaResultDTO dto = restTemplate.getForObject(PATH_API + "/planets", PlanetaResultDTO.class);
		return dto;
	}

}
