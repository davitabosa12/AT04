package br.ufc.at04;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufc.at04.dto.ExceptionDTO;
import br.ufc.at04.dto.PersonCreateDTO;
import br.ufc.at04.dto.PersonDetailDTO;
import br.ufc.at04.dto.PersonSummaryDTO;
import br.ufc.at04.exception.BreedNotFoundException;
import br.ufc.at04.exception.PersonNotFoundException;
import br.ufc.at04.model.BreedEntity;
import br.ufc.at04.model.Person;
import br.ufc.at04.repository.BreedRepository;
import br.ufc.at04.repository.PersonRepository;

@RestController
@RequestMapping("user")
public class PersonController {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	BreedRepository breedRepository;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PersonSummaryDTO> createPerson(@RequestBody PersonCreateDTO dto) {
		Person p = new Person(dto);
		p = personRepository.save(p);
		return ResponseEntity.created(getLocation(p)).body(new PersonSummaryDTO(p));
	}

	@GetMapping(value = "{personName}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PersonDetailDTO> getPerson(@PathVariable("personName") String userName) {
		Person p = personRepository.findByPersonName(userName).orElseThrow(PersonNotFoundException::new);

		return ResponseEntity.ok(new PersonDetailDTO(p));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<PersonSummaryDTO>> getAllPersons() {
		return ResponseEntity.ok(
				personRepository.findAll().stream().map(person -> new PersonSummaryDTO(person)).toList());
	}

	@DeleteMapping(value = "{personName}")
	public ResponseEntity<Void> removePerson(@PathVariable("personName") String personName) {
		Person p = personRepository.findByPersonName(personName).orElseThrow(PersonNotFoundException::new);
		personRepository.delete(p);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "{personName}/{breedName}")
	public ResponseEntity<PersonDetailDTO> setFavoriteBreed(@PathVariable("personName") String personName,
			@PathVariable("breedName") String breedName) {
		Person p = personRepository.findByPersonName(personName).orElseThrow(PersonNotFoundException::new);
		BreedEntity breed = breedRepository.findByBreedName(breedName).orElseThrow(BreedNotFoundException::new);
		p.setFavoriteBreed(breed);
		p = personRepository.save(p);
		return ResponseEntity.ok(new PersonDetailDTO(p));
	}

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handlePersonNotFound(PersonNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(ex));
	}

	@ExceptionHandler(BreedNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleBreedNotFound(BreedNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(ex));
	}

	private URI getLocation(Person u) {
		return ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(u.getId())
				.toUri();
	}
}
