package br.ufc.at04.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ceo.dog.sdk.Breed;

public interface DogAPIService {
	List<Breed> listAllBreeds() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException;
	List<String> getAllImagesByBreed(String breedName);
	List<String> getRandomImageByBreed(String breedName, int numberOfImages) throws ClientProtocolException, IOException;
}
