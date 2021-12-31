package br.com.starwars.spec;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.dto.PlanetaIntegracaoDTO;
import br.com.starwars.dto.PlanetaResultDTO;
import br.com.starwars.repository.PlanetaRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlanetaSpecTest {
	
	@Mock
	private PlanetaRepository repository;	

	@InjectMocks
	private PlanetaSpec spec;

	@Test()
    public void is_nome_unico_invalido_test() { 
		Planeta planeta = getPlaneta();		
		when(repository.findByNome(planeta.getNome())).thenReturn(planeta);
		
		try {
			spec.isNomeUnico(planeta);
			fail("Falha. Uma exceção deve ser lançada!");
		} catch (Exception ex) {
   		 	assertEquals("Já existe um planeta cadastrado com o nome " +planeta.getNome() + ".",  ex.getMessage());
   	 	}
	}
	
	@Test()
    public void is_nome_unico_valido_test() { 
		Planeta planeta = getPlaneta();		
		when(repository.findByNome(planeta.getNome())).thenReturn(planeta);
		
		try {
			planeta.setNome("novo_nome");
			spec.isNomeUnico(planeta);
			assertNotEquals(getPlaneta().getNome(), planeta.getNome());
		} catch (Exception ex) {
			fail("Falha. Uma exceção deve ser lançada!");
   	 	}
	}
	
	@Test()
    public void is_nome_invalido_test() { 
		Planeta planeta = getPlaneta();
		try {			
			spec.isNomeValido(getPlanetaResultDTO(), planeta);
			fail("Falha. Uma exceção deve ser lançada!");
		} catch (Exception ex) {
			assertEquals("Planeta " + planeta.getNome() + " inválido.",  ex.getMessage());
   	 	}
	}
	
	@Test()
    public void is_nome_valido_test() { 
		Planeta planeta = getPlaneta();
		try {	
			planeta.setNome("Tatooine");
			spec.isNomeValido(getPlanetaResultDTO(), planeta);
			assertTrue(getPlanetaResultDTO().getResults().size()>0);
		} catch (Exception ex) {
			fail("Falha. Uma exceção deve ser lançada!");
   	 	}
	}
	
	public Planeta getPlaneta() {
    	PlanetaDTO planetaDTO = new PlanetaDTO();
        planetaDTO.setNome("teste_nome");
        planetaDTO.setClima("teste_clima");
        planetaDTO.setTerreno("teste_terreno");
        return new Planeta(planetaDTO);
    }
	
	public PlanetaResultDTO getPlanetaResultDTO() {
		
		ArrayList<String> films = new  ArrayList<>();
		ArrayList<PlanetaIntegracaoDTO> results = new  ArrayList<>();
		
		films.add("filme 1");
		films.add("filme 2");
		films.add("filme 3");
		
		PlanetaIntegracaoDTO planetaIntegracaoDTO = new PlanetaIntegracaoDTO();
		planetaIntegracaoDTO.setFilms(films);
		planetaIntegracaoDTO.setName("Tatooine");
		results.add(planetaIntegracaoDTO);
		
		PlanetaResultDTO planetaResultDTO = new PlanetaResultDTO();
		planetaResultDTO.setResults(results);
		
		return planetaResultDTO;
	}

}
