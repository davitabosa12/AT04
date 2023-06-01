package br.ufc.at04.model;

import java.util.UUID;

import br.ufc.at04.dto.PersonCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_entity")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;
	
	@Column(unique = true)
	private String name;
	@ManyToOne(targetEntity = BreedEntity.class)
	@JoinColumn(name="breed_id", nullable=true)
	BreedEntity favoriteBreed;
	
	public Person() {
		
	}
	public Person(PersonCreateDTO dto) {
		this.name = dto.getUsername();
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
	public void setName(String username) {
		this.name = username;
	}
	public BreedEntity getFavoriteBreed() {
		return favoriteBreed;
	}
	public void setFavoriteBreed(BreedEntity favoriteBreed) {
		this.favoriteBreed = favoriteBreed;
	}
	
}
