package br.com.starwars.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.repository.PlanetaRepository;
import groovy.lang.Singleton;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlanetaServiceTest {
	
	@MockBean
    private PlanetaService planetaService;

    @Test
    public void fromDTO_test() { 
    	Planeta planeta = getPlaneta();
        PlanetaDTO planetaDTO = getPlanetaDTO();                
        
        assertEquals(planeta.getId(), planetaDTO.getId());
        assertEquals(planeta.getNome(), planetaDTO.getNome());
        assertEquals(planeta.getClima(), planetaDTO.getClima());
        assertEquals(planeta.getTerreno(), planetaDTO.getTerreno());
    }
    
    @Test
    public void salvar_planeta_test() {
    	Planeta planeta = getPlaneta();
        
        when(planetaService.salvar(planeta)).thenReturn(
        		new Planeta() {{
        			setId(10);
        			setClima(planeta.getClima());
        			setNome(planeta.getNome());
        			setTerreno(planeta.getTerreno());
        		}} 
        	);
        
        Planeta planetaNew = planetaService.salvar(planeta);        
        
        assertEquals(10, planetaNew.getId());
        assertEquals(planeta.getNome(), planetaNew.getNome());
        assertEquals(planeta.getClima(), planetaNew.getClima());
        assertEquals(planeta.getTerreno(), planetaNew.getTerreno());
    }
    
    @Test
    public void excluir_planeta_test() {
    	Planeta planeta = getPlaneta();
    	planetaService.excluir(planeta);
    	doNothing().when(this.planetaService).excluir(planeta);        
    }
    
    @Test
    public void obter_por_id_test() {
    	Planeta planeta = getPlaneta();
        planeta.setId(1);
        
        when(planetaService.obterPorId(planeta.getId())).thenReturn(
    		planeta
    	);  
        
        Planeta planetaNew = planetaService.obterPorId(1);
        
        assertEquals(planeta.getId(), planetaNew.getId());
        assertEquals(planeta.getNome(), planetaNew.getNome());
        assertEquals(planeta.getClima(), planetaNew.getClima());
        assertEquals(planeta.getTerreno(), planetaNew.getTerreno());        
    }
    
    @Test
    public void obter_todos_test() {
    	List<Planeta> planetas = new ArrayList<>();
        planetas.add(getPlaneta());
        planetas.add(getPlaneta());
        
        when(planetaService.obterTodos()).thenReturn(planetas);  
        
        List<Planeta> planetaList = planetaService.obterTodos();
        
        assertEquals(planetaList.size(), 2);        
    }
    
    @Test
    public void pesquisar_test() {
    	List<Planeta> planetas = new ArrayList<>();
        Planeta planeta = getPlaneta();  
        planeta.setNome("teste2");
        planetas.add(planeta);
        
        when(planetaService.pesquisar(planeta.getNome())).thenReturn(planetas);  
        
        List<Planeta> planetaList = planetaService.pesquisar(planeta.getNome());
        
        assertEquals(planetaList.size(), 1);        
    }
    
    public Planeta getPlaneta() {
    	PlanetaDTO planetaDTO = getPlanetaDTO();
    	when(planetaService.fromDTO(planetaDTO)).thenReturn(
        		new Planeta(planetaDTO));
        
        return planetaService.fromDTO(planetaDTO);
    }
    
    public PlanetaDTO getPlanetaDTO() {
    	PlanetaDTO planetaDTO = new PlanetaDTO();
        planetaDTO.setNome("teste_nome");
        planetaDTO.setClima("teste_clima");
        planetaDTO.setTerreno("teste_terreno");
        return planetaDTO;
    }
    
 }
