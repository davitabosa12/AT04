package br.ufc.at04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.at04.dto.BreedImageDTO;
import br.ufc.at04.dto.BreedSummaryDTO;
import br.ufc.at04.model.BreedEntity;
import br.ufc.at04.repository.BreedRepository;
import br.ufc.at04.service.DogAPIService;
import br.ufc.at04.service.DogAPIServiceImpl;
import ceo.dog.sdk.Breed;


@RestController
@RequestMapping("breed")
public class MainController {
	DogAPIService dogService = new DogAPIServiceImpl();
	@Autowired
	BreedRepository breedRepository;
	
	@GetMapping(name = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody ResponseEntity<List<BreedSummaryDTO>> getAllDog() {
		return ResponseEntity.ok(breedRepository.findAll().stream().map(BreedSummaryDTO::new).toList());
	}
	
	@PostMapping("{breed}/like")
	public @ResponseBody ResponseEntity<Integer> likeDog(@PathVariable("breed") String breedName){
		int changed = breedRepository.incrementVote(breedName);
		return ResponseEntity.ok(changed);
	}
	
	@GetMapping("{breed}")
	public @ResponseBody ResponseEntity<BreedSummaryDTO> getDog(@PathVariable("breed") String breedName){
		Optional<BreedEntity> breed = breedRepository.findByBreedName(breedName);
		return ResponseEntity.ofNullable(breed.map(b -> new BreedSummaryDTO(b)).orElseGet(() -> null));
	}
	
	@GetMapping("{breed}/image")
	public @ResponseBody ResponseEntity<BreedImageDTO> getDogImage(@PathVariable("breed") String breedName){
		Optional<BreedEntity> breed = breedRepository.findByBreedName(breedName);
		List<String> urls = new ArrayList<>();
		try {
			urls = dogService.getRandomImageByBreed(breedName, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.internalServerError().build();
		}
		BreedImageDTO dto = new BreedImageDTO();
		dto.setImageUrl(urls.get(0));
		return ResponseEntity.ok(dto);
	}
}
