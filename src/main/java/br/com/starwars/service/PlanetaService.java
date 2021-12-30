package br.com.starwars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.dto.PlanetaResultDTO;
import br.com.starwars.exception.ObjectNotFoundException;
import br.com.starwars.integracao.PlanetaIntegracao;
import br.com.starwars.repository.PlanetaRepository;
import br.com.starwars.spec.PlanetaSpec;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaSpec spec;
	
	@Autowired
	private PlanetaRepository repository;	
	
	@Autowired
	private PlanetaIntegracao planetaIntegracao;
		
	public Planeta fromDTO(PlanetaDTO planetaDTO) {		
		return new Planeta(planetaDTO);
	}

	public Planeta salvar(Planeta planeta) {
		planeta.setId(null);
		PlanetaResultDTO planetaResultDTO = planetaIntegracao.getPlanetasStarWars();
		spec.validarNome(planetaResultDTO,planeta);
		planeta.setAparicaoFilme(planetaResultDTO);		 		
		return repository.save(planeta); 
	}

	public void excluir(Planeta planeta){		
		repository.deleteById(planeta.getId());
	}

	public Planeta obterPorId(Integer planetaId) throws ObjectNotFoundException {		
		Optional<Planeta> planeta = repository.findById(planetaId);
		return planeta.orElseThrow(() -> new ObjectNotFoundException("Planeta não encontrado."));
	}
	
	public List<Planeta> obterTodos() throws ObjectNotFoundException {		
		return repository.findAll();
	}
	
	public List<Planeta> pesquisar(String nome){
		return repository.pesquisar(nome);
	}
}