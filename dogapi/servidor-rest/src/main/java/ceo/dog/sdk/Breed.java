package ceo.dog.sdk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

public class Breed {
	String name;
	
	List<String> subBreed;
	
	String password;
	public Breed(String name, List<String> subBreed) {
		this.name = name;
		this.subBreed = subBreed;
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
	
	
}
