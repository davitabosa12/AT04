package br.ufc.at04.dto;

import java.util.Optional;


import br.ufc.at04.model.BreedEntity;
import br.ufc.at04.model.Person;

public class PersonDetailDTO {
	String username;
	BreedSummaryDTO favortiteBreed;
	public PersonDetailDTO() {
		super();
	}
	public PersonDetailDTO(Person u) {
		this.username = u.getName();
		Optional<BreedEntity> breed = Optional.ofNullable(u.getFavoriteBreed());
		this.favortiteBreed = breed.map(b -> new BreedSummaryDTO(b)).orElseGet( () -> null);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BreedSummaryDTO getBreed() {
		return favortiteBreed;
	}
	public void setBreed(BreedSummaryDTO breed) {
		this.favortiteBreed = breed;
	}
	
}
