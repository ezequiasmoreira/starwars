package br.com.starwars.dto;

import java.util.List;

public class PlanetaIntegracaoDTO {
	private String name;
	private List<String> films;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFilms() {
		return films;
	}
	public void setFilms(List<String> films) {
		this.films = films;
	}
	
}
