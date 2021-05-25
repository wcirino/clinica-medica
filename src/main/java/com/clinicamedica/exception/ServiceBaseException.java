package com.clinicamedica.exception;

public class ServiceBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ServiceBaseException(String exception) {
		super(exception);
	}
	
	public ServiceBaseException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
