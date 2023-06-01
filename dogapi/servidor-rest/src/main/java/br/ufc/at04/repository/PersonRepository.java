package br.ufc.at04.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.at04.model.BreedEntity;
import br.ufc.at04.model.Person;

public interface PersonRepository extends JpaRepository<Person, UUID>{
	@Query(value = "SELECT * FROM PERSON_ENTITY WHERE name = ?1", nativeQuery = true)
	Optional<Person> findByPersonName(String name);
}
