package br.com.starwars.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaResultDTO;
import br.com.starwars.exception.ValidateException;
import br.com.starwars.repository.PlanetaRepository;


@Service
public class PlanetaSpec  {
	@Autowired
	private PlanetaRepository repository;	
	
	public void validarNome(PlanetaResultDTO planetaResultDTO, Planeta planeta) {
		isNomeUnico(planeta);
		isNomeValido(planetaResultDTO, planeta);
	}
	
	public void isNomeUnico(Planeta planeta) {
		Throwable throwable = new Throwable("nome");
		Planeta planetaNew = repository.findByNome(planeta.getNome());
		
		if(planetaNew != null) {
			throw new ValidateException(
					"Já existe um planeta cadastrado com o nome " + planeta.getNome() + ".", throwable);
		}
	}
	
	public void isNomeValido(PlanetaResultDTO planetaResultDTO, Planeta planeta) {
		Throwable throwable = new Throwable("nome");
		Boolean nomeValido = planetaResultDTO.getResults().stream().anyMatch(planetaIntegracaoDTO -> 
			planetaIntegracaoDTO.getName().equals(planeta.getNome()));
		if(!nomeValido) {
			throw new ValidateException(
					"Planeta " + planeta.getNome() + " inválido.", throwable);
		}
	}
}
