package br.ufc.at04.dto;

public class ExceptionDTO {
	String message;
	
	public ExceptionDTO(Exception ex) {
		this.message = ex.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
