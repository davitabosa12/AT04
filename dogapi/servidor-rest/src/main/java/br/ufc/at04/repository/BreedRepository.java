package br.ufc.at04.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ufc.at04.model.BreedEntity;
import jakarta.transaction.Transactional;

public interface BreedRepository extends JpaRepository<BreedEntity, UUID> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE BREED_ENTITY breed SET breed.votes = breed.votes + 1 WHERE breed.name = ?1", nativeQuery = true)
	int incrementVote(String breedName);

	@Transactional
	@Modifying
	@Query(value = "UPDATE BREED_ENTITY breed SET breed.votes = breed.votes - 1 WHERE breed.name = ?1 AND breed.votes > 0", nativeQuery = true)
	int decrementVote(String breedName);

	@Query(value = "SELECT * FROM BREED_ENTITY WHERE name = ?1", nativeQuery = true)
	Optional<BreedEntity> findByBreedName(String breedName);

	@Query(value = "SELECT * FROM BREED_ENTITY ORDER BY VOTES DESC", nativeQuery = true)
	List<BreedEntity> findBreedOrderByVotes();
}
