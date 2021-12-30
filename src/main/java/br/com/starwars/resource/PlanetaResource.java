package br.com.starwars.resource;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.dto.PlanetaResultDTO;
import br.com.starwars.integracao.PlanetaIntegracao;
import br.com.starwars.service.PlanetaService;


@RestController
@RequestMapping("/planetas")
public class PlanetaResource {

	@Autowired
	private PlanetaService service;
	
	@Autowired
	private PlanetaIntegracao planetaIntegracao;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Planeta> obterPorId(@PathVariable Integer id) {
		Planeta planeta = service.obterPorId(id);
		return ResponseEntity.ok().body(planeta);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findAll() {
		List<Planeta> planetas = service.obterTodos();  
		return ResponseEntity.ok().body(planetas);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Planeta planeta = service.obterPorId(id);
		service.excluir(planeta);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional(rollbackOn = Exception.class)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Planeta> salvar(@RequestBody PlanetaDTO planetaDTO) {
		Planeta planeta = service.fromDTO(planetaDTO);
		planeta = service.salvar(planeta);
		return ResponseEntity.ok().body(planeta);
	}	
	
	@RequestMapping(value="/starwars", method=RequestMethod.GET)
	public PlanetaResultDTO getPlanetasIntegracao() {
		return planetaIntegracao.getPlanetasStarWars();
	}
	
	@RequestMapping(value="/pesquisar", method=RequestMethod.GET)
	public ResponseEntity<List<Planeta>> pesquisar(
			@RequestParam(value="nome", defaultValue="") String nome) {
		List<Planeta> planetas = service.pesquisar(nome);  
		return ResponseEntity.ok().body(planetas);
	}

}
