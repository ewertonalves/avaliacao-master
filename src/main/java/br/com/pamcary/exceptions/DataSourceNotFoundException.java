package br.com.pamcary.exceptions;

public class DataSourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataSourceNotFoundException(String message) {
		super(message);
	}
}
