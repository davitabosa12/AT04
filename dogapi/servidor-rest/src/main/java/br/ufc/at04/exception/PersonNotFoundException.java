package br.ufc.at04.exception;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		super("Person not found.");
	}
	
}
