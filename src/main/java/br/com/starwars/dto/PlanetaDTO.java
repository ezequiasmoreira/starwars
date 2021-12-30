package br.com.starwars.dto;

import java.util.List;

public class PlanetaDTO {	
	private Integer id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer aparicaoFilme;

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
	
}
