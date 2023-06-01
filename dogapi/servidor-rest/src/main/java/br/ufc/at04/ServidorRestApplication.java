package br.ufc.at04;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.ufc.at04.model.BreedEntity;

import br.ufc.at04.repository.BreedRepository;

import br.ufc.at04.service.DogAPIService;
import br.ufc.at04.service.DogAPIServiceImpl;
import ceo.dog.sdk.Breed;

@SpringBootApplication
public class ServidorRestApplication {

	@Autowired
	BreedRepository breedRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServidorRestApplication.class, args);
	}
	
	@Bean
	public void populateRepo() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException {
		DogAPIService dogApi = new DogAPIServiceImpl();
		Stream<Breed> dogStream = dogApi.listAllBreeds().stream();
		List<BreedEntity> breeds = dogStream.map(breed -> new BreedEntity(breed.getName(), breed.getSubBreed())).toList();
		breedRepository.saveAll(breeds);
	}

}
