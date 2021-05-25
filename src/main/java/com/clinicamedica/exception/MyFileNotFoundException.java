package com.clinicamedica.exception;

public class MyFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyFileNotFoundException(String exception) {
		super(exception);
	} 
	
	public MyFileNotFoundException(String exception, Throwable cause) {
		super(exception,cause);
	} 
	
}
