package br.ufc.at04.exception;

public class BreedNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BreedNotFoundException() {
		super("Breed not found.");
	}
}
