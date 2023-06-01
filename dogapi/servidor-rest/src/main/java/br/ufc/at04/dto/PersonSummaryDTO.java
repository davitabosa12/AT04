package br.ufc.at04.dto;

import java.util.UUID;

import br.ufc.at04.model.Person;

public class PersonSummaryDTO {
	UUID id;
	String username;
	
	public PersonSummaryDTO() {
		super();
	}
	public PersonSummaryDTO(Person user) {
		this.id = user.getId();
		this.username = user.getName();
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
