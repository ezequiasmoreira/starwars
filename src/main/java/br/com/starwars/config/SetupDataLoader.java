package br.com.starwars.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import br.com.starwars.domain.Planeta;
import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.repository.PlanetaRepository;

@Configuration
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PlanetaRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    	PlanetaDTO dto = new PlanetaDTO();
    	dto.setClima("teste-clima");
    	dto.setNome("teste-nome");
    	dto.setTerreno("teste-terreno");
        repository.saveAll(Arrays.asList(new Planeta(dto)));
    }
}