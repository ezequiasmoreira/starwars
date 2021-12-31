package br.com.starwars.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.starwars.domain.Planeta;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlanetaRepositoryTest {
	
	@Autowired
    private PlanetaRepository planetaRepository;

    @Test
    public void inserir_planeta() {
        Planeta planeta = new Planeta();
        planeta.setNome("teste_nome");
        planeta.setClima("teste_clima");
        planeta.setTerreno("teste_terreno");
        planetaRepository.save(planeta);
        
        Integer quantidadePlaneta = planetaRepository.findAll().size();
        assertEquals(1, quantidadePlaneta);
    }
    
    @Test
    public void obter_planeta_por_nome() {
        Planeta planeta = new Planeta();
        planeta.setNome("teste_abcd");
        planeta.setClima("teste_clima");
        planeta.setTerreno("teste_terreno");
        planetaRepository.save(planeta);
        
        Integer quantidadePlaneta = planetaRepository.findAll().size();
        assertEquals(1, quantidadePlaneta);
        
        Planeta planetaNome = planetaRepository.findByNome("teste_abcd");
        assertNotNull(planetaNome);
        assertEquals(planeta, planetaNome);
        
        List<Planeta> planetaNomeLike = planetaRepository.pesquisar("abcd");
        assertNotNull(planetaNomeLike);
        assertTrue(planetaNomeLike.size() > 0);
    }
    
    @Test
    public void deletarr_planeta() {
        Planeta planeta = new Planeta();
        planeta.setNome("teste_abcd");
        planeta.setClima("teste_clima");
        planeta.setTerreno("teste_terreno");
        planetaRepository.save(planeta);
        
        Planeta planetaFiltro = planetaRepository.findByNome("teste_abcd");
        assertNotNull(planetaFiltro);
        
        planetaRepository.delete(planetaFiltro);
        planetaFiltro = planetaRepository.findByNome("teste_abcd");
        assertNull(planetaFiltro);
    }

}
