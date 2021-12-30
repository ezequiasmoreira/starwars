package br.com.starwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.starwars.domain.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Integer>{
	@Transactional(readOnly=true)
	Planeta findByNome(String nome);
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Planeta obj WHERE obj.nome LIKE %:nome%")
	List<Planeta> pesquisar(@Param("nome") String nome);	
}
