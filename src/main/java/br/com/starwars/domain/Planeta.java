package br.com.starwars.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.starwars.dto.PlanetaDTO;
import br.com.starwars.dto.PlanetaResultDTO;

@Entity
public class Planeta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer aparicaoFilme;
	
	public Planeta() {}
	
	public Planeta(PlanetaDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.clima = dto.getClima();
		this.terreno = dto.getTerreno();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicaoFilme() {
		return aparicaoFilme;
	}

	public void setAparicaoFilme(PlanetaResultDTO planetaResultDTO) {
		planetaResultDTO.getResults().forEach(planetaIntegracaoDTO->{
			if (planetaIntegracaoDTO.getName().equals(this.getNome())) {
				this.aparicaoFilme = planetaIntegracaoDTO.getFilms().size();
			}
		});
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		return Objects.equals(id, other.id);
	}	

}
