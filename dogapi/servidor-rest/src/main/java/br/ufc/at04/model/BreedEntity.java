package br.ufc.at04.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.lang.NonNull;

import ceo.dog.sdk.Breed;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;

@Entity
public class BreedEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;
	
	@Column(unique = true)
	String name;
	
	@OneToMany(targetEntity = Person.class, mappedBy = "favoriteBreed")
	Set<Person> users;
	
	List<String> subBreed;
	Long votes = 0L;
	

	public BreedEntity() {
		super();
	}


	public BreedEntity(String name, List<String> subBreed) {
		this.name = name;
		this.subBreed = subBreed;
	}
	

	public BreedEntity(UUID id, String name, List<String> subBreed) {
		super();
		this.id = id;
		this.name = name;
		this.subBreed = subBreed;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@NonNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSubBreed() {
		return subBreed;
	}
	public void setSubBreed(List<String> subBreed) {
		if(subBreed == null) {
			this.subBreed = new ArrayList<>();
		} else {
			this.subBreed = subBreed;
		}
	}


	public Set<Person> getPersons() {
		return users;
	}


	public void setUsers(Set<Person> users) {
		this.users = users;
	}


	public Long getVotes() {
		return votes;
	}


	public void setVotes(Long votes) {
		this.votes = votes;
	}
	
	
	
	
	
}
