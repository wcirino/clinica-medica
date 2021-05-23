package com.clinicamedica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FileException(String exception) {
		super(exception);
	}
	
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
