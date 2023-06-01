package br.ufc.at04.dto;

import java.util.List;
import java.util.UUID;

import br.ufc.at04.model.BreedEntity;

public class BreedDetailDTO {
	private UUID id;

	private String name;
	private Long votes = 0L;
	private int favorited = 0;
	private List<PersonSummaryDTO> peopleFavorited;
	
	public BreedDetailDTO() {
		super();
	}
	public BreedDetailDTO(BreedEntity breed) {
		this.id = breed.getId();
		this.name = breed.getName();
		this.votes = breed.getVotes();
		this.favorited = breed.getPersons().size();
		this.peopleFavorited = breed.getPersons().stream().map(p -> new PersonSummaryDTO(p)).toList();
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getVotes() {
		return votes;
	}
	public void setVotes(Long votes) {
		this.votes = votes;
	}
	public int getFavorited() {
		return favorited;
	}
	public List<PersonSummaryDTO> getPeopleFavorited() {
		return peopleFavorited;
	}
	public void setPeopleFavorited(List<PersonSummaryDTO> peopleFavorited) {
		this.peopleFavorited = peopleFavorited;
	}

}
