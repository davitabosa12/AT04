package br.ufc.at04.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.springframework.boot.json.GsonJsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.internal.LinkedTreeMap;

import ceo.dog.sdk.Breed;

public class DogAPIServiceImpl implements DogAPIService {
	
	String dogApiUrl;
	public DogAPIServiceImpl() {
		this.dogApiUrl = "https://dog.ceo/api";
	}
	public DogAPIServiceImpl(String dogApiUrl) {
		this.dogApiUrl = dogApiUrl;
	}

	@Override
	public List<Breed> listAllBreeds() throws ClientProtocolException, IOException, JsonMappingException, JsonProcessingException {
		Content c  = Request.Get(getEndpoint("/breeds/list/all")).execute().returnContent();
		GsonJsonParser gson = new GsonJsonParser();
		Map<String, Object> parsed = gson.parseMap(c.asString());
		@SuppressWarnings("unchecked")
		LinkedTreeMap<String, List<String>> message = (LinkedTreeMap<String, List<String>>) parsed.get("message");
		return message.entrySet().stream().map(entry -> new Breed(entry.getKey(), entry.getValue())).toList();
		
		
	}

	@Override
	public List<String> getAllImagesByBreed(String breedName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRandomImageByBreed(String breedName, int numberOfImages) throws ClientProtocolException, IOException {
		String requestPath = "/breed/" + breedName + "/images/random/" + numberOfImages;
		Content c  = Request.Get(getEndpoint(requestPath)).execute().returnContent();
		GsonJsonParser gson = new GsonJsonParser();
		Map<String, Object> parsed = gson.parseMap(c.asString());
		@SuppressWarnings("unchecked")
		List<String> message = (List<String>) parsed.get("message");
		return message;
	}
	
	private String getEndpoint(String path) {
		return this.dogApiUrl + path;
	}

}
